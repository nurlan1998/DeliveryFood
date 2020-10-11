package com.example.deliveryfood.ui.auth.tips

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.deliveryfood.R
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_selected_location.*
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class SelectedLocationFragment : Fragment(R.layout.fragment_selected_location), OnMapReadyCallback {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private val locationRequestId = 100
    private lateinit var mGoogleMap: GoogleMap

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fusedLocationProviderClient = FusedLocationProviderClient(requireActivity())

        mapView.onCreate(savedInstanceState)

        btnSaveAddress.setOnClickListener {
            findNavController().navigate(R.id.action_selectedLocationFragment3_to_addressFragment3)
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap
    }

    private fun getLocation() {
        if (checkForLocationPermission()) {
            updateLocation()
        } else {
            askLocationPermission()
        }
    }

    var mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(result: LocationResult) {

            val location: Location = result.lastLocation
            updateAddressUI(location)
        }
    }

    private fun updateLocation() {
        val locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 1000
        locationRequest.fastestInterval = 5000

        fusedLocationProviderClient = FusedLocationProviderClient(requireContext())
        if (checkForLocationPermission()) {
            fusedLocationProviderClient.requestLocationUpdates(
                locationRequest, mLocationCallback,
                Looper.myLooper()
            )
        }
    }

    fun updateAddressUI(location: Location) {
        val addressList: ArrayList<Address>
        try {
            val gecoder = Geocoder(requireContext(), Locale.getDefault())
            addressList = gecoder.getFromLocation(
                location.latitude,
                location.longitude,
                1
            ) as ArrayList<Address>

            tvAddressLocation.text = addressList[0].getAddressLine(0)

            val latLng = LatLng(location.latitude, location.longitude)
            Log.e("MyLocation", location.longitude.toString() + " " + location.latitude.toString())

            val marker = MarkerOptions().position(latLng)
            mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
            mGoogleMap.addMarker(marker)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun checkForLocationPermission(): Boolean {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        )
            return true
        return false
    }

    private fun askLocationPermission() {
        ActivityCompat.requestPermissions(
            requireContext() as Activity,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            locationRequestId
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == locationRequestId && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            getLocation()
        }
    }

    private fun initGoogleMap() {
        mapView.getMapAsync(this)
    }

    private fun initMap() {
        if (checkForLocationPermission()) {
            initGoogleMap()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onResume() {
        super.onResume()
        getLocation()
    }

    override fun onStart() {
        super.onStart()
        initMap()
        mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }
}