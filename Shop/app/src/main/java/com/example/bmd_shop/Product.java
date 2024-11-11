package com.example.bmd_shop;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    int id, price, image;
    String name;
    boolean box;

    Product(int _id, String _describe, int _price, int _image, boolean _box){
        id = _id;
        name = _describe;
        price = _price;
        image = _image;
        box = _box;}
    protected Product(Parcel in){
        id = in.readInt();
        name = in.readString();
        price = in.readInt();
        image = in.readInt();
        box = in.readByte() !=0;}
    @Override
    public int describeContents() {return 0;}
    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(price);
        dest.writeInt(image);
        dest.writeByte((byte) (box? 1:0));}
    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {return new Product(source);}
        @Override
        public Product[] newArray(int size) {return new Product[size];}};}
