package com.madcamp.week1.contacts

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.FragmentActivity
import coil.load
import coil.transform.CircleCropTransformation
import com.madcamp.week1.databinding.ActivityContactsDetailBinding

class ContactsDetailActivity : FragmentActivity() {
  private lateinit var binding: ActivityContactsDetailBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityContactsDetailBinding.inflate(layoutInflater)
    //  setContentView(R.layout.activity_contacts_detail)
    setContentView(binding.root)
    val intent = intent
    val bundle = intent.getBundleExtra("bundle_key")!!
    val info_photo = bundle.getString("info_photo")
    val info_id = bundle.getString("info_id")
    val info_email = bundle.getString("info_email")
    if (info_id != null) {
      Log.i("PLZ", info_id)
      binding.displayPhoto.load(info_photo) {
        crossfade(true)
        placeholder(android.R.drawable.ic_menu_report_image)
        transformations(CircleCropTransformation())
      }
      binding.displayId.text = info_id
      binding.displayEmail.text = info_email
    }
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (item.itemId == android.R.id.home) {
      // to reverse the scene transition animation
      supportFinishAfterTransition()
    }
    return super.onOptionsItemSelected(item)
  }
}
