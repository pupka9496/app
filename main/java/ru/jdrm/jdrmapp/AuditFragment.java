package ru.jdrm.jdrmapp;

import static ru.jdrm.jdrmapp.DB.Read.getCascadeNewReportData;
import static ru.jdrm.jdrmapp.DB.Write.test;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.jdrm.jdrmapp.design.Audit.Audit;
import ru.jdrm.jdrmapp.design.Audit.AuditH.AuditA;
import ru.jdrm.jdrmapp.design.Audit.AuditC;
import ru.jdrm.jdrmapp.design.Audit.EAudit;
import ru.jdrm.jdrmapp.design.Audit.message.Message;
import ru.jdrm.jdrmapp.design.Audit.Section.SectionC;
import ru.jdrm.jdrmapp.design.Audit.Section.SectionA;



import java.util.ArrayList;

public class AuditFragment extends Fragment implements AuditA.OnItemListener, SectionA.OnItemListener {
    RecyclerView infoSectionRecyclerView;
    RecyclerView infoAuditRecyclerView;
    AuditA infoAuditAdaptor;
    SectionA infoSectionAdaptor;
    Message message;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_audit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AuditC.pointAudit = EAudit.Management;

        test();
        initWidgets(view);
        setSectionsView();

    }

    @Override
    public void onResume(){
        super.onResume();
        setAuditAdapter();
    }


    private void initWidgets(@NonNull View view){
        infoSectionRecyclerView = view.findViewById(R.id.sectionList);
        infoAuditRecyclerView = view.findViewById(R.id.info_audit);
    }

    private void setSectionsView(){

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        infoSectionRecyclerView.setLayoutManager(layoutManager);

        // ременный сбор getNameAudit()
        infoSectionAdaptor = new SectionA(getContext(), SectionC.getNameAudit(), this);

        infoSectionRecyclerView.setAdapter(infoSectionAdaptor);

        setAuditAdapter();
    }

    public void setAuditAdapter(){
        ArrayList<Audit> dataAudit = Audit.AuditForSection(EAudit.getValue(AuditC.pointAudit));
        setDataAuditRecycler(dataAudit);
    }

    private void setDataAuditRecycler(ArrayList<Audit> dataAudit) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        infoAuditRecyclerView.setLayoutManager(layoutManager);


        if(!dataAudit.isEmpty()){
            infoAuditAdaptor = new AuditA(getContext(), dataAudit, this);
            infoAuditRecyclerView.setAdapter(infoAuditAdaptor);
        }else {
            message = new Message(getContext(),"Аудитов нет ");
            infoAuditRecyclerView.setAdapter(message);
        }
    }

    @Override
    public void onItemClick(int position, Audit audit) {
        AuditC.positionAudit = position;
        Intent intent = new Intent(getContext(), AuditDescription.class);
        startActivity(intent);
    }


    @Override
    public void onItemClick(int position, SectionC dataSection) {
        AuditC.pointAudit = EAudit.fromValue(dataSection.getTitle());
        setAuditAdapter();
    }
}