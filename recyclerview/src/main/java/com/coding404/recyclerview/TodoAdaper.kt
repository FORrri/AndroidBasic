package com.coding404.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coding404.recyclerview.databinding.RecyclerviewItemBinding

//2. 리사이클러뷰 어댑터를 상속받음
class TodoAdaper(val list : ArrayList<Todo>) : RecyclerView.Adapter<TodoAdaper.TodoViewHolder>() { //오버라이딩 3개 아래처럼 필요

    //리스트를 선언 or 생성자 매개변수에서 list를 받음

    //1.내부 클래스 뷰홀더 생성
    //생성자의 매개변순는 리사이클러뷰 아이템을 받는다. 뷰홀더를 상속받음
    inner class TodoViewHolder(val binding : RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {

        //데이터를 받아서 화면에 연결하는 코드(멤버변수 or 함수)
        //val x = binding.reTitle -멤버변수로 받기
        fun setItem(todo: Todo) { //함수로 받기
            binding.reTitle.text = todo.title
            binding.reContent.text = todo.content
        }
        //실행 순서 2

    }

    //뷰 홀더가 새로 만들어질때 호출됨 - 레이아웃을 인플레이트르해서 뷰객체 생성
    //매개변수(현재 연결할 뷰객체, 부모의 뷰그룹의미, 이 뷰를 부모뷰에 바로 연결할지말지 - 이 메서드 안에서 로딩시킴) -> 거의 고정적인 코드임
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view : RecyclerviewItemBinding = RecyclerviewItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)

        return TodoViewHolder(view)
        //실행 순서 1
    }

    //리사이클러뷰에서 관리하는 리스트의 사이즈를 반환
    override fun getItemCount(): Int {
        return list.size
    }

    //뷰 홀더가 데이터가 연결될 때마다 호출 - 즉 한 행(아이템)에 대한 처리를 넣어줌
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) { //뷰홀더, 인덱스
        val todo = list[position]
        holder.setItem(todo)

        Log.d("myLog", "onBindViewHolder: $position")
        //실행 순서 3

    }


}
