package com.musicrecord.shared;

import com.google.gwt.user.client.ui.SuggestOracle;

public class UserSuggestion  implements SuggestOracle.Suggestion {

    private Category user;
    
    public UserSuggestion(Category user) {
        this.user = user;
    }

    @Override
    public String getDisplayString() {
        return getReplacementString();
    }

    @Override
    public String getReplacementString() {
        return user.getCategoryname();
    }

    public Category getUser() {
        return user;
    }  

}
