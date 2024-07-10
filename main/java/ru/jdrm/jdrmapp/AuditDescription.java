package ru.jdrm.jdrmapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.jdrm.jdrmapp.design.Audit.Audit;
import ru.jdrm.jdrmapp.design.Audit.CategoryH.CategoryA;
import ru.jdrm.jdrmapp.design.Audit.AuditC;
import ru.jdrm.jdrmapp.design.Audit.CategoryH.CategoryC;
import ru.jdrm.jdrmapp.design.Audit.EAudit;
import ru.jdrm.jdrmapp.design.Audit.Number.NumberC;
import ru.jdrm.jdrmapp.design.Audit.Number.NumberA;
import ru.jdrm.jdrmapp.design.NavBarActivity;


public class AuditDescription extends AppCompatActivity implements CategoryA.OnItemListener, NumberA.OnItemListener {


    CategoryA infoCategoryScoreAdaptor;
    RecyclerView infoCategoryScoreRecyclerView;
    NumberA infoNumberPPAdaptor;
    RecyclerView infoNumberPPRecyclerView;
    Audit audit = new Audit();
    EAudit nameAudit = AuditC.pointAudit;
    int positionAudit = AuditC.positionAudit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_audit_description);

        audit = Audit.AuditForSectionAndPosition(EAudit.getValue(nameAudit), positionAudit);
        assert audit != null;

        TextView name_audit = findViewById(R.id.name_audit);
        name_audit.setText(audit.getTitle());

        TextView description_audit = findViewById(R.id.description_audit);
        description_audit.setText(audit.getDescription());

        TextView name_section = findViewById(R.id.name_section);
        name_section.setText(EAudit.getValue(nameAudit));
//        text_dicription
        initWidgets();
        setWeekView();


    }

    @Override
    public void onResume(){
        super.onResume();
        setAuditAdapter();
    }



    private void initWidgets() {
        infoCategoryScoreRecyclerView = findViewById(R.id.categoryScore);
        infoNumberPPRecyclerView = findViewById(R.id.numberPP);
    }

    private void setWeekView() {
        RecyclerView.LayoutManager layoutManagerCategory = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        infoCategoryScoreRecyclerView.setLayoutManager(layoutManagerCategory);
        infoCategoryScoreAdaptor = new CategoryA(this, CategoryC.getNameAudit(
                Audit.getReportId(EAudit.getValue(nameAudit), audit.getTitle())),this);
        infoCategoryScoreRecyclerView.setAdapter(infoCategoryScoreAdaptor);

        RecyclerView.LayoutManager layoutManagerNumber = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        infoNumberPPRecyclerView.setLayoutManager(layoutManagerNumber);
        infoNumberPPAdaptor = new NumberA(this, NumberC.getNameAudit(
                Audit.getSubItem(EAudit.getValue(nameAudit), audit.getSub_item_number())),this);
        infoNumberPPRecyclerView.setAdapter(infoNumberPPAdaptor);

        setAuditAdapter();
    }

    private void setAuditAdapter() {
        TextView dref = findViewById(R.id.breddf);
        TextView des = findViewById(R.id.text_dicription);

        dref.setText(audit.getName_category());
        des.setText(audit.getRoadmap());
    }

    public void BackList(View v){
        Intent intent = new Intent(this, NavBarActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(int position, CategoryC dataMetric) {
        setAuditAdapter();
    }

    @Override
    public void onItemClick(int position, NumberC dataMetric) {
        setAuditAdapter();
    }
}
