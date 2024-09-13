package com.nano.dailytask

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nano.dailytask.ui.CosmeticViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var btnProducts: AppCompatButton
    private lateinit var btnProductsDimension: AppCompatButton
    private lateinit var btnProductsReview: AppCompatButton

    private val productViewModel:CosmeticViewModel by viewModels<CosmeticViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()
        initListener()
    }

    private fun initViews(){
        btnProducts = findViewById(R.id.btnProducts)
        btnProductsDimension = findViewById(R.id.btnProductsDimension)
        btnProductsReview = findViewById(R.id.btnProductsReview)
    }

    private fun initListener(){
        btnProducts.setOnClickListener {
            productViewModel.getAllProducts()
        }

        btnProductsDimension.setOnClickListener {

        }

        btnProductsReview.setOnClickListener {

        }
    }
}