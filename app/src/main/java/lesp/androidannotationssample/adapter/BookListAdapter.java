package lesp.androidannotationssample.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

import lesp.androidannotationssample.view.BookListItemView;
import lesp.androidannotationssample.view.BookListItemView_;
import lesp.androidannotationssample.vo.Book;

@EBean
public class BookListAdapter extends BaseAdapter {

    @RootContext
    Context context;

    private List<Book> books;

    public BookListAdapter() {
        books = new ArrayList<>();
        books.add(new Book("Hello", "Adele", "Hello from the other side."));
        books.add(new Book("Creep", "Radiohead", "I'm a weirdo."));
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Book getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BookListItemView item = null;
        if(convertView == null) {
            item = BookListItemView_.build(context);
        } else {
            item = (BookListItemView) convertView;
        }

        item.bind(getItem(position));

        return item;
    }
}
