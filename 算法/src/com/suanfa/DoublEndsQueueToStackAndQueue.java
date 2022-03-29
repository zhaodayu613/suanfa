package com.suanfa;
//用双向链表实现队列和栈
//栈：数据先进后出，弹夹  ；  队列：数据先进先出，排队；

import org.w3c.dom.Node;

public class DoublEndsQueueToStackAndQueue {
    //创建一个双向链表的基本属性
    public  static class Node<T>{
        public  T value;
        public Node<T> last;
        public Node<T> next;
        public Node(T data) {
            this.value=data;
        }
    }

    public static  class DoubleEndsQueue<T>{
        public Node<T> head;
        public Node<T> tail;
        //从头部添加数据；
        public void addFromHead(T value){
            Node<T> cur = new Node<>(value);
            //如果头部为空
            if(head==null){
                head = cur;
                tail = cur;
            }else {
                head.last=cur;
                head = cur;
            }
        }
        //从尾部添加数据；
        public void addFromTail(T value){
            Node<T> cur = new Node<>(value);
            //如果头部为空
            if(head==null){
                head = cur;
                tail = cur;
            }else {
                tail.next=cur;
                tail = cur;
            }
        }

        //从头部取数据
        public T popFromHead(){
            if(head == null){
                return null;
            }
            Node<T> cur = head;
            if(head == tail){
                head = null;
                tail = null ;
            }else {
                head = head.next;
                //把元素分离开来
                cur.next = null;
                head.last = null;
            }
            return cur.value;
        }
        //从头部取数据
        public T popFromBootom(){
            if(head == null){
                return null;
            }
            Node<T> cur = tail;
            if(head == tail){
                head = null;
                tail = null ;
            }else {
               tail = tail.last;
                //把元素分离开来
                cur.last = null;
                tail.next = null;
            }
            return cur.value;
        }

        //实现栈
        public static class MyStack<T>{
            private  DoubleEndsQueue<T> queue;

            public MyStack() {
                queue = new DoubleEndsQueue<T>();
            }
            public void  push(T value){
                queue.addFromHead(value);
            }
            public T pop(){
              return   queue.popFromHead(); //先进后出  就是从头部取元素
            }
        }

        //实现队列
        public static class MyQueue<T>{
            private DoubleEndsQueue<T> queue;

            public MyQueue() {
                queue = new DoubleEndsQueue<T> ();
            }
            public void  push(T value){
                queue.addFromHead(value);
            }
            public T Pop(){
                return queue.popFromBootom();
            }
            public boolean isEmptu(){
                return  false; //写个queue.isEmpty() 方法；
            }
        }
    }
}
