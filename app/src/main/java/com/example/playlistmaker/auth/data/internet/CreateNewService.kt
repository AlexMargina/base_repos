package com.example.playlistmaker.auth.data.internet

import android.os.AsyncTask
import androidx.collection.arrayMapOf
import com.google.gson.JsonParser

/**
 * Фоновый Async Task создания нового продукта
 **/
class CreateNewService : AsyncTask<String, String, String>() {

    /**
     * Перед согданием в фоновом потоке показываем прогресс диалог
     **/

    override fun onPreExecute()
    {
        super.onPreExecute()
    }

    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg p0: String?): String? {

        run {
            val name = ""//inputName.getText().toString()
            val price = ""//inputPrice.getText().toString()
            val description = ""//inputDesc.getText().toString()

            // Заполняем параметры
            val jParser = JsonParser()
            val url_create_product = ""
            val params = arrayMapOf<String, String>()
            params.put("name", name)
            params.put("price", price)
            params.put("description", description)

            // получаем JSON объект
            //val json : JSONObject = jParser.makeHttpRequest (url_create_product, "POST", params)

            // Log.d("Create Responce", json.toString())

            return null

        }


        /**
         * После оконачния скрываем прогресс диалог
         **/
        fun onPostExecute(file_url: String) {
            //pDialog.dismiss()
        }
    }
}


