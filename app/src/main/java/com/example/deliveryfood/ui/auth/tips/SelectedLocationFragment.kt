package com.example.deliveryfood.ui.auth.tips

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.deliveryfood.R
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_selected_location.*

class SelectedLocationFragment : Fragment(R.layout.fragment_selected_location){

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapView.onCreate(savedInstanceState)
        mapView.onResume()

        fusedLocationProviderClient = FusedLocationProviderClient(requireActivity())

        if(ActivityCompat.checkSelfPermission(requireContext(),
            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getCurrentLocation()
        }else{
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),44)
        }

        btnSaveAddress.setOnClickListener {
            findNavController().navigate(R.id.action_selectedLocationFragment3_to_addressFragment3)
        }
    }

    override fun onResume() {
        super.onResume()
        getCurrentLocation()
    }

    private fun getCurrentLocation(){

        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        var task = fusedLocationProviderClient.lastLocation
        task.addOnSuccessListener {location ->
            if(location != null){
                mapView.getMapAsync{ googleMap ->
                    val latLng = LatLng(location.latitude,location.longitude)
                    Log.e("MyLocation",location.longitude.toString() + location.latitude.toString())
                    val marker = MarkerOptions().position(latLng)
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15f))
                    googleMap.addMarker(marker)
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 44) {
            if (grantResults.lastIndex > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation()
            }
        }
    }
}