package ru.jdrm.jdrmapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.jdrm.jdrmapp.design.PlantItem;
import ru.jdrm.jdrmapp.design.Diagram.DiagramC;
import ru.jdrm.jdrmapp.design.Diagram.DiagramA;
import ru.jdrm.jdrmapp.design.reviewratings.BarLabels;
import ru.jdrm.jdrmapp.design.reviewratings.RatingReview;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiagramFragment extends Fragment {


    public DiagramFragment() {}


    DiagramC androidData;
    DiagramA adaptor;
    List<DiagramC> dataList;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_diagram, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView factoryName = requireView().findViewById(R.id.factoryText);
        factoryName.setText(PlantItem.getFactories());

        recyclerView = view.findViewById(R.id.info_plant);

        GenerationItem();

        TextView exitButton = view.findViewById(R.id.exitButton);
        TextView startButton = view.findViewById(R.id.refreshButton);

        exitButton.setOnClickListener(this::Exit);

        startButton.setOnClickListener(this::startNewActivity3);

    }

    public void Exit(View view) {
        Intent intent = new Intent(getContext(), StartActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    public void startNewActivity3(View v) {
        Intent intent2 = new Intent(getContext(), PlantItemChoose.class);
        startActivity(intent2);
    }

    public void GenerationItem() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();

        Pair[] colors = new Pair[]{
                new Pair<>(Color.parseColor("#0c96c7"), Color.parseColor("#00fe77")),
                new Pair<>(Color.parseColor("#ff5d9b"), Color.parseColor("#ffaa69")),

        };

        int minValue = 30;

        int[] raters = new int[]{
                minValue + new Random().nextInt(100 - minValue + 1),
                minValue + new Random().nextInt(100 - minValue + 1)
        };

        RatingReview ratingReview = new RatingReview(100, BarLabels.STYPE3, colors, raters);

        androidData = new DiagramC(R.string.final_score, ratingReview);
        dataList.add(androidData);

        raters = new int[]{
                minValue + new Random().nextInt(100 - minValue + 1),
                minValue + new Random().nextInt(100 - minValue + 1)
        };

        ratingReview = new RatingReview(100, BarLabels.STYPE3, colors, raters);

        androidData = new DiagramC(R.string.managment,ratingReview);
        dataList.add(androidData);


        androidData = new DiagramC(R.string.prepearing_production,ratingReview);
        dataList.add(androidData);
        raters = new int[]{
                minValue + new Random().nextInt(100 - minValue + 1),
                minValue + new Random().nextInt(100 - minValue + 1)
        };

        ratingReview = new RatingReview(100, BarLabels.STYPE3, colors, raters);
        androidData = new DiagramC(R.string.SF_m,ratingReview);
        dataList.add(androidData);
        raters = new int[]{
                minValue + new Random().nextInt(100 - minValue + 1),
                minValue + new Random().nextInt(100 - minValue + 1)
        };

        ratingReview = new RatingReview(100, BarLabels.STYPE3, colors, raters);
        androidData = new DiagramC(R.string.SF_e,ratingReview);
        dataList.add(androidData);
        raters = new int[]{
                minValue + new Random().nextInt(100 - minValue + 1),
                minValue + new Random().nextInt(100 - minValue + 1)
        };

        ratingReview = new RatingReview(100, BarLabels.STYPE3, colors, raters);

        androidData = new DiagramC(R.string.quality,ratingReview);
        dataList.add(androidData);

        raters = new int[]{
                minValue + new Random().nextInt(100 - minValue + 1),
                minValue + new Random().nextInt(100 - minValue + 1)
        };

        ratingReview = new RatingReview(100, BarLabels.STYPE3, colors, raters);

        androidData = new DiagramC(R.string.supply_chain,ratingReview);
        dataList.add(androidData);
        raters = new int[]{
                minValue + new Random().nextInt(100 - minValue + 1),
                minValue + new Random().nextInt(100 - minValue + 1)
        };

        ratingReview = new RatingReview(100, BarLabels.STYPE3, colors, raters);
        androidData = new DiagramC(R.string.technical_development,ratingReview);
        dataList.add(androidData);
        raters = new int[]{
                minValue + new Random().nextInt(100 - minValue + 1),
                minValue + new Random().nextInt(100 - minValue + 1)
        };

        ratingReview = new RatingReview(100, BarLabels.STYPE3, colors, raters);
        androidData = new DiagramC(R.string.OTiB,ratingReview);
        dataList.add(androidData);

        adaptor = new DiagramA(dataList);
        recyclerView.setAdapter(adaptor);

    }

}
