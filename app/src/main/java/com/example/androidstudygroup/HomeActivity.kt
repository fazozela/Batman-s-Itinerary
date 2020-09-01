package com.example.androidstudygroup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidstudygroup.adapter.VillainAdapter
import com.example.androidstudygroup.model.Villain
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), VillainAdapter.OnVillainCLickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var user_name = intent.getStringExtra("keyUserName")

        txt_user.text = "$user_name a que villano vencerás hoy?"

        setupRecycler()

    }

    private fun setupRecycler(){
        recyclerview.layoutManager = LinearLayoutManager(this)
        val villains_list = listOf<Villain>(
            Villain("Joker", "https://comicvine1.cbsistatic.com/uploads/scale_small/12/124259/7538232-three-jokers-1-cvr-fnl-1583776056592.jpg","Letal", "Ultimo atraco: Banco BNB"),
            Villain("Ra's al Ghul", "https://comicvine1.cbsistatic.com/uploads/scale_small/10/100647/5018100-batman-eternal-46.jpg", "Peligro medio", "Ultimo atraco: Banco Union"),
            Villain("Catwoman", "https://comicvine1.cbsistatic.com/uploads/scale_small/11125/111253436/6784476-catwoman_vol_5_1_textless_variant.jpg", "Peligro medio", "Ultimo atraco: Uyustus"),
            Villain("Penguin", "https://comicvine1.cbsistatic.com/uploads/scale_small/6/64770/2048679-penguin_4.jpg", "Peligro animal", "Ultimo atraco: Lago Titicaca"),
            Villain("Riddler", "https://comicvine1.cbsistatic.com/uploads/scale_small/11131/111319715/6462105-batman_vol_3_27_textless.jpg", "Letal", "Ultimo atraco: Cine Center"),
            Villain("Two-Face", "https://comicvine1.cbsistatic.com/uploads/scale_small/10/100647/5462570-tf.jpg", "Doble Cara", "Ultimo atraco: Gobierno"),
            Villain("Bane", "https://comicvine1.cbsistatic.com/uploads/scale_small/13/132517/5614213-bane_bm18.jpg", "Vengativo", "Ultimo atraco: Pozo YPFB"),
            Villain("Mr. Freeze", "https://comicvine1.cbsistatic.com/uploads/scale_small/6/66303/2361007-batman_annual_02_1000.jpg", "Frío", "Ultimo atraco: Helados Panda"),
            Villain("Poison Ivy", "https://comicvine1.cbsistatic.com/uploads/scale_small/11114/111147698/5939265-1499257220009.jpg", "Letal", "Ultimo atraco: Laboratorios Bagó")

        )

        recyclerview.adapter = VillainAdapter(this, villains_list, this)

    }

    override fun onItemClick(item: Villain) {
        val intent = Intent(this, VillainActivity::class.java)
        intent.putExtra("imgURL", item.img)
        startActivity(intent)
    }

}