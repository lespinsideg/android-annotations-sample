package lesp.androidannotationssample.fragment;

import android.support.v4.app.ListFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;

import lesp.androidannotationssample.adapter.BookListAdapter;
import lesp.androidannotationssample.bus.EventBus;
import lesp.androidannotationssample.vo.Book;

@EFragment
public class BookListFragment extends ListFragment {

    @Bean BookListAdapter adapter;
    @Bean
    EventBus bus;

    @AfterViews
    void bindAdapter() {
        setListAdapter(adapter);
    }

    @ItemClick(android.R.id.list)
    void listItemClicked(Book book) {
        bus.send(book);
    }


}
