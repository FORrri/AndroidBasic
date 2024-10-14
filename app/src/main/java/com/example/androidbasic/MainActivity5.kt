package com.example.androidbasic

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import java.text.SimpleDateFormat
import java.util.Calendar

const val TAG = "myLog" //상수

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets

        //xml에 위젯을 얻음
        var genderBtn: Button = findViewById(R.id.gender_btn)
        var genderText: TextView = findViewById(R.id.gender_text)

        var nameEdit: EditText = findViewById(R.id.name_edit)
        var nameText: TextView = findViewById(R.id.name_text)

        var birthBtn: Button = findViewById(R.id.bitrh_btn)
        var birthText: TextView = findViewById(R.id.bitrh_text)

        //genderBtn.setOnClickListener(View.OnClickListener ( {v:View-> })) //아래처럼 생략해서 나타낼 수 있음
        genderBtn.setOnClickListener {
            //Toast.makeText(this,"성별버튼 클릭", Toast.LENGTH_SHORT).show()

//            AlertDialog.Builder(this)
//                .setIcon(R.drawable.ic_launcher_background)
//                .setTitle("제목입니다")
//                .setMessage("종료하시겠습니까?")
////              .setPositiveButton("예",DialogInterface.OnClickListener{dialog, which -> }) //아래처럼 생략 가능
//                .setPositiveButton("예") {dialog, which ->
//                    Toast.makeText(this,"예 버튼 클릭 했음", Toast.LENGTH_SHORT).show()
//                }
//                .setNegativeButton("아니요") {dialog, whtich ->
//                    Toast.makeText(this,"아니오 버튼 클릭 했음", Toast.LENGTH_SHORT).show()
//                    dialog.dismiss() //아니오 누르면 다이어로그 종료
//                }
//                .show()

            AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_launcher_background)
                .setTitle("성별을 선택하세요")
                .setItems(arrayOf("여자", "남자")) { dialog, which -> //안쓸거면 _
                    //which는 인덱스를 반환해줌
                    when (which) {
                        0 -> {
                            genderText.text = "여자"
                        }

                        1 -> {
                            genderText.text = "남자"
                        }
                    }
                    genderText.visibility = View.VISIBLE
                    dialog.dismiss()
                }
                .setNegativeButton("끄기") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()

        }

        //editText가 변경할 때 마다 동작하는 이벤트
        //editText에서 사용자가 클릭하는 버튼을 감지하려면 setOnKeyListener이벤트를 쓰면 됩니다.
        /*
        nameEdit.addTextChangedListener {
            //Toast.makeText(this,"클릭", Toast.LENGTH_SHORT).show()

            var text = nameEdit.text.toString() //사용자가 입력한 값
            nameText.text = text

            //textView의 visibility속성 변경
            nameText.visibility = View.VISIBLE

            //내장 되어 있는 글씨 색상 변경
            nameText.setTextColor(Color.BLUE) //글씨색상
            nameText.setBackgroundColor(Color.GREEN) //배경색상

            //사용자가 정의한 색상
            val color1 = ContextCompat.getColor(this, R.color.myColor1)
            val color2 = ContextCompat.getColor(this, R.color.myColor3)

            nameText.setTextColor(color1)
            nameText.setBackgroundColor(color2)

        }
         */

        //사용자가 키보드를 클릭하면 동작
        nameEdit.setOnKeyListener { v, keyCode, event ->
            Log.d(TAG, "onCreate: $event")

            if(event.action == KeyEvent.ACTION_DOWN) {
                if(event.action == KeyEvent.KEYCODE_ENTER) {
                    nameText.text = nameEdit.text.toString()
                    nameText.visibility = View.VISIBLE
                }
            }

            //true //->1. 이벤트 전파 중단(버튼UI 안닫힘)
            // -> 특정 키 입력이 발생했을 때 다른 기본 동작을 막고 싶을 때 사용
            // ->Enter 키를 누를 때 텍스트가 입력된 후 키보드가 그대로 유지되기를 원한다면 true를 반환하여 이벤트 전파를 막습니다
            false //2. 이벤트 계속 전파(버튼 UI 닫힘)
            //-> 이벤트를 현재 뷰에서 처리하더라도, 기본 동작(키보드 닫힘 등)이 발생하거나 다른 뷰에서도 이벤트가 전파되길 원할 때 사용
            //-> 키를 누른 후 키보드가 닫히도록 기본 동작을 유지하고 싶다면 false를 반환하여 이벤트 전파를 허용합니다

        }

        //생일선택 버튼
        birthBtn.setOnClickListener {

            //오늘날짜 구하기(util파일)
            val cal: Calendar = Calendar.getInstance()
            val yy = cal.get(Calendar.YEAR)
            var mm = cal.get(Calendar.MONTH)
            var dd = cal.get(Calendar.DAY_OF_MONTH)

            //로켓 -> 로그창을 찍는거
//          Log.d(TAG, "onCreate: $year, $month, $day")

            //DatePickerDialog(this, DatePickerDialog.OnDateSetListener({view, year, month, dayOfMonth })) //아래처럼 생략가능
            val dialog = DatePickerDialog(this, { view, year, month, dayOfMonth ->
                //ok버튼을 누를때 동작함

                //사용자가 선택한 날짜를 문자형식으로 저장
                val seleted = "$year-${month+1}-${dayOfMonth}"
                Log.d(TAG, "onCreate: $seleted")

                //현재시간(밀리초) - 사용자가 선택한 값(밀리초) => 년도로 치환 => 나이를 구함
                val nowMillis = System.currentTimeMillis() //1970~지금까지의 밀리초를 구함

                val sdf = SimpleDateFormat("yyyy-MM-dd") //날짜형식
                val date = sdf.parse(seleted)
                val millis = date.time //밀리초를 구함

                val result = (nowMillis - millis) / 1000 / 60 / 60 / 24 / 365 //년도로 치환
                Log.d(TAG, "onCreate: $result")

                //나이 숨김 영역에 result+"세" 형식으로 값을 넣고 보여주기
                birthText.text = "$result 세"
                birthText.visibility = View.VISIBLE

            }, yy, mm, dd
            )
            dialog.datePicker.maxDate = System.currentTimeMillis() //현재 날짜 다음 값을 선택하지 못하게 함
            dialog.show() //다이얼로그 show





        }


        //xml에서 이벤트 연결하기
        fun handleClick() {
            Toast.makeText(this, "제목을 클릭했습니다", Toast.LENGTH_SHORT).show()
        }

    }
}
