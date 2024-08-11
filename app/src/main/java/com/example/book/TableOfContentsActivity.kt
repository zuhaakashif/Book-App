package com.example.book

import android.content.Intent
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TableOfContentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_of_contents)

        val tableLayout: TableLayout = findViewById(R.id.tableOfContents)

        // Populate table of contents
        val chapters = listOf(
            Chapter("Chapter 1: The Curriculum", 3),
            Chapter("Chapter 2: The Syllabus", 4),
            Chapter("Chapter 3: The Student", 8),
            Chapter("Chapter 4: The Audiovisual", 10),
            Chapter("Chapter 5: Professor's Final Course", 11),
            Chapter("Chapter 6: The Orientation", 14),
            Chapter("Chapter 7: The Classroom", 17),
            Chapter("Chapter 8: Taking Attendance", 21)

            // Add more chapters as needed
        )

        for (chapter in chapters) {
            val row = TableRow(this)

            val nameTextView = TextView(this)
            nameTextView.text = chapter.name
            nameTextView.setPadding(16, 8, 16, 8)
            row.addView(nameTextView)

            val pageNumberTextView = TextView(this)
            pageNumberTextView.text = chapter.pageNumber.toString()
            pageNumberTextView.setPadding(16, 8, 16, 8)
            row.addView(pageNumberTextView)

            row.setOnClickListener {
                navigateToPdfPage(chapter.pageNumber)
            }

            tableLayout.addView(row)
        }

        val fab: FloatingActionButton = findViewById(R.id.fab2)
        fab.setOnClickListener {
            // Open MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun navigateToPdfPage(pageNumber: Int) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("pageNumber", pageNumber)
        startActivity(intent)
    }

    data class Chapter(val name: String, val pageNumber: Int)
}
