package lesp.androidannotationssample.view;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import lesp.androidannotationssample.R;
import lesp.androidannotationssample.vo.Book;

@EViewGroup(R.layout.book_list_item)
public class BookListItemView extends LinearLayout {
    @ViewById
    TextView title;

    @ViewById
    TextView author;
    public BookListItemView(Context context) {
        super(context);
    }

    public void bind(Book book) {
        title.setText(book.getTitle());
        author.setText(book.getAuthor());
    }
}
