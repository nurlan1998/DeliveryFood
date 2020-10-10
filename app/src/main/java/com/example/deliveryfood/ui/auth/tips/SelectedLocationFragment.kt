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
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
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

class SelectedLocationFragment : Fragment(R.layout.fragment_selected_location),OnMapReadyCallback{

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private val locationRequestId = 100
    private lateinit var mGoogleMap: GoogleMap

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapView.onCreate(savedInstanceState)
        mapView.onResume()
        mapView.getMapAsync(this)
        getLocation()

        fusedLocationProviderClient = FusedLocationProviderClient(requireActivity())

        btnSaveAddress.setOnClickListener {
            findNavController().navigate(R.id.action_selectedLocationFragment3_to_addressFragment3)
        }
    }

    var mLocationCallback = object : LocationCallback(){
        override fun onLocationResult(result: LocationResult) {

            val location: Location = result.lastLocation
            updateAddressUI(location)
        }
    }

    override fun onResume() {
        super.onResume()
        getLocation()
    }

    private fun getLocation(){
        if(checkForLocationPermission()){
            updateLocation()
        }else{
            askLocationPermission()
        }
    }

    private fun updateLocation(){
        val locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 1000
        locationRequest.fastestInterval = 5000

        fusedLocationProviderClient = FusedLocationProviderClient(requireActivity())
        if(checkForLocationPermission()){
            fusedLocationProviderClient.requestLocationUpdates(locationRequest,mLocationCallback,
                Looper.myLooper())
        }
    }
//
//    private fun init(){
//        etSearch.setOnEditorActionListener { textView, i, keyEvent ->
//            if(i == EditorInfo.IME_ACTION_SEARCH
//                || i == EditorInfo.IME_ACTION_DONE
//                || keyEvent.action == KeyEvent.ACTION_DOWN
//                || keyEvent.action == KeyEvent.KEYCODE_ENTER) {
//
//            }
//            return@setOnEditorActionListener false
//            }
//        }

    fun updateAddressUI(location: Location){
        val addressList: ArrayList<Address>
        try {
            val gecoder = Geocoder(requireContext(), Locale.getDefault())
            addressList = gecoder.getFromLocation(location.latitude,location.longitude,1) as ArrayList<Address>


            tvAddressLocation.text = (addressList[0].getAddressLine(0)).toString()

            val latLng = LatLng(location.latitude,location.longitude)
            Log.e("MyLocation",location.longitude.toString() + " " + location.latitude.toString())

            val marker = MarkerOptions().position(latLng)
            mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15f))
            mGoogleMap.addMarker(marker)
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    private fun checkForLocationPermission(): Boolean{
        if(ActivityCompat.checkSelfPermission(requireContext(),Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        return true
        return false
    }

    private fun askLocationPermission(){
        ActivityCompat.requestPermissions(requireContext() as Activity, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),locationRequestId)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == locationRequestId && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                getCurrentLocation()
            getLocation()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
            getLocation()
    }
    //
//    private fun getCurrentLocation(){
//
//        if (ActivityCompat.checkSelfPermission(
//                requireContext(),
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                requireContext(),
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            return
//        }
//        var task = fusedLocationProviderClient.lastLocation
//        task.addOnSuccessListener {location ->
//            if(location != null){
//                mapView.getMapAsync{ googleMap ->
//                    val latLng = LatLng(location.latitude,location.longitude)
//                    Log.e("MyLocation",location.longitude.toString() + location.latitude.toString())
//                    val marker = MarkerOptions().position(latLng)
//                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15f))
//                    googleMap.addMarker(marker)
//                }
//            }
//        }
//    }
}