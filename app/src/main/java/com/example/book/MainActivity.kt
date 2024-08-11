package com.example.book
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    private lateinit var pdfView: PDFView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            // Open TableOfContentsActivity
            val intent = Intent(this, TableOfContentsActivity::class.java)
            startActivity(intent)
        }

        val pageNumber = intent.getIntExtra("pageNumber", 0)

        val pdfView: PDFView = findViewById(R.id.pdfView)
        val parentLayout: ViewGroup = pdfView.parent as ViewGroup // Find the parent layout

        parentLayout.setBackgroundColor(Color.parseColor("#CFBFB3"))// Set the background color of the parent layout

        pdfView.fromAsset("tuesdays with morrie.pdf")
            .defaultPage(pageNumber)
            .enableSwipe(true)
            .swipeHorizontal(true)
            .scrollHandle(DefaultScrollHandle(this))
            .enableAntialiasing(true)
            .spacing(0)
            .pageFling(true)
            .load()


    }
}
