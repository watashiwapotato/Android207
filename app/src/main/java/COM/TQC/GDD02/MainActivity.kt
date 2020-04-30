// https://data.gov.tw/
// 展演資料：
// https://data.gov.tw/dataset/6220#r0
// API 網址：
// https://cloud.culture.tw/frontsite/trans/emapOpenDataAction.do?method=exportEmapJsonByMainType&mainType=10
package COM.TQC.GDD02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private var tv : TextView ?= null
    private var btn: Button ?= null
    private var pb: ProgressBar ?= null

    private val handler = object : Handler(Looper.getMainLooper())
    {
        override fun handleMessage(msg: Message)
        {
            // 5. TO DO
            when (msg.what)
            {
                MainActivity.MSG_CONNECTION_OK -> if (msg.obj != null)
                {
                    try {
                        val sb = StringBuilder()
                        // 5. TO DO


                        tv!!.setText(sb.toString())
                    }
                    catch (e: Exception)
                    {
                        e.printStackTrace()
                        tv!!.setText(e.message)
                    }
                }
                MainActivity.MSG_CONNECTION_ERROR -> tv!!.text = this@MainActivity.resources.getString(R.string.msg_connection_error)
            }
            super.handleMessage(msg)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        tv = findViewById<TextView>(R.id.main_textView1)
        pb = findViewById(R.id.main_progressBar1)
        btn = findViewById(R.id.main_button1)
        btn!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                // 3. TO DO

                Thread(Runnable {
                    // 3. TO DO
                    val conn = HippoWebService()

                    // 4. TO DO
                    val msg = Message()


                }).start()
            }
        })
    }

    companion object {
        private val MSG_CONNECTION_OK = 0x1001
        private val MSG_CONNECTION_ERROR = 0x2999
        private val TAG : String = "HIPPO_DEBUG"
        private val uriAPI : String = "https://cloud.culture.tw/frontsite/trans/emapOpenDataAction.do?method=exportEmapJsonByMainType&mainType=10"
    }
}
