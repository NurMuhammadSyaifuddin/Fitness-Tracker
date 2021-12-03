package com.project.fitness.ui.main.training

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.project.fitness.R
import com.project.fitness.databinding.FragmentTrainingBinding
import com.project.fitness.ui.main.MainActivity
import com.project.fitness.ui.main.training.running.RunningFragment
import com.project.fitness.utils.hasLocPermission
import dagger.hilt.android.AndroidEntryPoint
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions

@AndroidEntryPoint
class TrainingFragment : Fragment(), EasyPermissions.PermissionCallbacks {

    private var _binding: FragmentTrainingBinding? = null
    private val binding get() = _binding as FragmentTrainingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTrainingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onAction()
    }

    private fun onAction() {
        binding.apply {
            btnRunning.setOnClickListener {
                (activity as MainActivity?)?.findNavController(R.id.nav_host_controller)?.navigate(R.id.nav_running)
            }
            btnCycling.setOnClickListener {
                (activity as MainActivity?)?.findNavController(R.id.nav_host_controller)?.navigate(R.id.nav_cycling)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {}

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)){
            AppSettingsDialog.Builder(this).build().show()
        }else{
            reqPermission()
        }
    }

    private fun reqPermission() {
        if (hasLocPermission(requireContext())){
            return
        }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q){
            EasyPermissions.requestPermissions(
                this,
                "We need your location permissions to continue",
                REQ_CODE_LOCATION_PERMISSIONS,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        }else{
            EasyPermissions.requestPermissions(
                this,
                "We need your location permissions to continue",
                REQ_CODE_LOCATION_PERMISSIONS,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION,
                Manifest.permission.ACTIVITY_RECOGNITION
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    companion object {

        private const val PARAM1 = "param1"
        private const val PARAM2 = "param2"
        private const val REQ_CODE_LOCATION_PERMISSIONS = 0

        @Volatile
        private var instance: TrainingFragment? = null

        fun getInstance(param1: String, param2: String): TrainingFragment =
            instance ?: synchronized(this) {
                instance ?: TrainingFragment().apply {
                    arguments = Bundle().apply {
                        putString(PARAM1, param1)
                        putString(PARAM2, param2)
                    }
                    instance = this
                }
            }
    }
}