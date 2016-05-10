package lesp.androidannotationssample.fragment;

import android.support.v4.app.Fragment;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import lesp.androidannotationssample.R;
import lesp.androidannotationssample.bus.EventBus;
import lesp.androidannotationssample.vo.Book;
import rx.functions.Action1;

@EFragment(R.layout.fragment_contents)
public class ContentsFragment extends Fragment {
    @Bean
    EventBus bus;

    @ViewById
    TextView title;

    @ViewById
    TextView author;

    @ViewById
    TextView contents;


    @AfterViews
    void subscribeBus() {
        bus.toObserverable().subscribe(new Action1<Object>() {
            @Override
            public void call(Object obj) {
                if(obj instanceof Book) {
                    updateContents(((Book) obj));
                }
            }
        });
    }

    @UiThread
    void updateContents(Book book) {
        title.setText(book.getTitle());
        author.setText(book.getAuthor());
        contents.setText(book.getContents());
    }
}