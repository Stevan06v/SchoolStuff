package com.company;

public class LinkedList {
    public LinkedList() {
        start = null;
    }

    protected ListItem start;

    public void add(int value){
        ListItem newItem = new ListItem(value);

        if(start == null) {
            this.start = newItem;
            return;
        }
        //an letztes item anhängen
        ListItem temp = start;

        while(temp.next != null){
            temp= temp.next;
        }
        temp.next = newItem;
    }


    public void get(int pos){

    }


    public void remove(int value){
        if(start == null) {
            return;
        }
        ListItem temp = start;

        if(start.value == value) {
            start = start.next;
            return;
        }

        while(temp.next != null && temp.next.value != value ){
           temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public void print(){
        ListItem temp = start;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }

    }

}
