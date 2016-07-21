package com.lz.www.ambts.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.ContactsContract;


import com.lz.www.ambts.model.Contacts;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/27.
 */
public class ContactsResolver {

    /**
     * 获取手机号返回实体集
     *
     * */
    public ArrayList<Contacts> getContacts(Context context){

        ArrayList<Contacts> list=new ArrayList<Contacts>();
        ContentResolver resolver=context.getContentResolver();
        Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor=resolver.query(uri,null,null,null,null);
        while (cursor.moveToNext()){
            String name=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String number=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            Contacts contacts=new Contacts(name,number);
            list.add(contacts);
        }
        return list;
    }

    /**
     * 根据姓名查找手机号
     *
     * */
    public Contacts queryContacts(Context context, String number){
        Uri uri=Uri.parse("content://com.android.contacts/data/phones/filter/"+number);
        ContentResolver resolver=context.getContentResolver();
        Cursor cursor=resolver.query(uri,new String[]{"display_name"},null,null,null);
        if(cursor.moveToNext()){
            String name=cursor.getString(0);
            Contacts contacts=new Contacts(name,number);
            return  contacts;
        }
        return null;
    }

    private void addContacts(Context context,Contacts contacts) throws RemoteException,OperationApplicationException{
//        Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
//        Uri dataUri =  Uri.parse("content://com.android.contacts/data");
//
//        ContentResolver resolver=context.getContentResolver();
//        ArrayList<ContentProviderOperation> ops=new ArrayList<ContentProviderOperation>();
//        ContentProviderOperation op1=ContentProviderOperation.newInsert(uri).withValueBackReference("raw_contact_id",0).withValue("data2", "Coder-pig");
//        ops.add(op1);
//        ContentProviderOperation op2=ContentProviderOperation.newInsert(dataUriuri).withValueBackReference("raw_contact_id",0).withValue("data2", "Coder-pig")
//                .build();
//        ops.add(op2);
//
//        resolver.applyBatch("com.android.contacts",ops);
    }
}
