package com.musicrecord.shared;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.sun.corba.se.pept.transport.ContactInfo;

import gwt.material.design.addins.client.autocomplete.base.MaterialSuggestionOracle;

public class UserOracle extends MaterialSuggestionOracle{

    private List<Category> contacts = new LinkedList<>();
    

    public void addContacts(ArrayList<Category> categories) {
        contacts.addAll(categories);
    }

    @Override
    public void requestSuggestions(Request request, Callback callback) {
        Response resp = new Response();
        if(contacts.isEmpty()){
            callback.onSuggestionsReady(request, resp);
            return;
        }
        String text = request.getQuery();
        text = text.toLowerCase();

        List<UserSuggestion> list = new ArrayList<>();

        for(Category contact : contacts){
            if(contact.getCategoryname().toLowerCase().contains(text)){
                list.add(new UserSuggestion(contact));
            }
        }
        resp.setSuggestions(list);
        callback.onSuggestionsReady(request, resp);
    }

}
