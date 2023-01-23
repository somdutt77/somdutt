package com.example.api.Model;

import android.widget.TextView;

public class ModelApi {
    TextView email;
    TextView name;

    public ModelApi(TextView email, TextView name) {
        this.email = email;
        this.name = name;
    }

    public TextView getEmail() {
        return email;
    }

    public void setEmail(TextView email) {
        this.email = email;
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public boolean isSuccessful() {
        return isSuccessful();
    }
}
