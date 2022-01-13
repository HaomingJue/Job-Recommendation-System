package com.jobrecommend.job.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtractResponseItem {

    public List<Extraction> extractions;
}
