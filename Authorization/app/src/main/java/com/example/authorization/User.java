package com.example.authorization;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class User {
    protected String name;
    protected String surname;
    protected String middleName;

    public User(String name, String surname, String middleName) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof User)) {
            return false;
        }

        User anotherUser = (User) obj;

        return anotherUser.name.equals(name) && anotherUser.surname.equals(surname) &&
                anotherUser.middleName.equals(middleName);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFullName() {
        return getSurname() + " " + getMiddleName() + " " + getName();
    }

    @NonNull
    @Override
    public String toString() {
        return surname + " " + name + " " + middleName + ";";
    }
}
