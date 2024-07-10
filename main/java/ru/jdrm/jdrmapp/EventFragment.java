package ru.jdrm.jdrmapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import ru.jdrm.jdrmapp.design.Event.EventC;
import ru.jdrm.jdrmapp.design.Event.EventA;
import ru.jdrm.jdrmapp.design.Event.EventNav.EventNavC;
import ru.jdrm.jdrmapp.design.Event.EventNav.EventNavA;

import java.util.ArrayList;
import java.util.List;

public class EventFragment extends Fragment {


    EventA adaptor;
    List<EventC> dataList;
    RecyclerView recyclerView;

    EventNavA adaptorNav;
    EventNavC dataEventNav;
    List<EventNavC> dataListNav;
    RecyclerView recyclerViewNav;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.info_event);
        recyclerViewNav = view.findViewById(R.id.eventNavView);
        GenerationItem();
        GenerationNavItem();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event, container, false);
    }

    public void GenerationItem() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();

        dataList.add(new EventC("название мероприятия 1"));

        adaptor = new EventA(dataList);

        recyclerView.setAdapter(adaptor);
    }

    public void GenerationNavItem() {
        // Создаем GridLayoutManager с горизонтальной ориентацией
        GridLayoutManager gridLayoutManagerNav = new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false);

        recyclerViewNav.setLayoutManager(gridLayoutManagerNav);

        // Инициализация списка данных
        dataListNav = new ArrayList<>();
        dataEventNav = new EventNavC("название метрики мероприятия");
        dataListNav.add(dataEventNav);

        adaptorNav = new EventNavA(dataListNav);
        recyclerViewNav.setAdapter(adaptorNav);
    }
}