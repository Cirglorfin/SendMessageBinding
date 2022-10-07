package com.example.sendmessagebinding.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * clase modelo que contiene el dato del usuario y el mensaje que manda.
 * Al ser User un objeto se debe implementar la interfaz Serializable y Parcelable en el objeto User.
 * @author Ciro León Espinosa Avilés
 * @version 1.0
 */
public class Message implements Serializable, Parcelable {
    private User user;
    private String content;
//Por defecto si no se declara un constructor, java implementa el constructor vacío

    public Message(User user)
    {
        this.user=user;

    }
    public  Message(User user,String content)
        {
            this.user=user;
            this.content=content;
        }

    protected Message(Parcel in) {
        user = in.readParcelable(User.class.getClassLoader());
        content = in.readString();
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    public User getUser() {

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(user, flags);
        dest.writeString(content);
    }

    //region MÉTODOS CREADOS DE LA INTERFAZ PARCELABLE


    //endregion
}
