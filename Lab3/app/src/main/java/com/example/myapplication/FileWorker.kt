package com.example.myapplication

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class FileWorker {
    private val FILE_NAME = "data.txt"
    fun saveText(lang: String, context: Context) {
        try {
            val file : FileOutputStream = context.openFileOutput(FILE_NAME, AppCompatActivity.MODE_APPEND)
            file.write(lang.toByteArray())
            Toast.makeText(context, "Файл збережено", Toast.LENGTH_SHORT).show()
            file.close()
        } catch (e: IOException) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show();
        }
    }

    fun getText(context: Context): String {
        val f = File("data.txt")
        if (!f.exists()) {
            val c = context.openFileOutput(FILE_NAME, AppCompatActivity.MODE_APPEND)
            c.write(ByteArray(0))
            c.close()
        }

        val fin : FileInputStream = context.openFileInput(FILE_NAME)

        var res = ""
        try {
            val bytes = ByteArray(fin.available())
            fin.read(bytes)

            res = String(bytes)

            if (res.equals(""))
                res = "No data"

        } catch (ex: IOException) {
            Toast.makeText(context, ex.message, Toast.LENGTH_SHORT).show()
        } finally {
            try {
                fin.close()
            } catch (ex: IOException) {
                Toast.makeText(context, ex.message, Toast.LENGTH_SHORT).show()
            }
        }
        return res
    }
}