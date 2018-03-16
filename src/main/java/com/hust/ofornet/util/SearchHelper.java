package com.hust.ofornet.util;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.hust.ofornet.dto.JobDto;
import com.hust.ofornet.pojo.Job;

public class SearchHelper {
	public static void createIndex(List<Job> jobs) throws Exception {

		List<Document> docList = new ArrayList<Document>();
		Document document;
		for (Job job : jobs) {
			document = new Document();
			Field id = new TextField("id", Integer.toString(job.getId()), Field.Store.YES);
			Field cid = new TextField("cid", Integer.toString(job.getCid()), Field.Store.YES);
			Field coid = new TextField("coid", Integer.toString(job.getCoid()), Field.Store.YES);
			Field name = new TextField("name", job.getName(), Field.Store.YES);
			Field catogoryName = new TextField("catogoryName", job.getCategory().getName(), Field.Store.YES);
			Field companyName = new TextField("companyName", job.getCompany().getName(), Field.Store.YES);
			Field city = new TextField("city", job.getCity(), Field.Store.YES);
			Field nature = new TextField("nature", job.getNature(), Field.Store.YES);
			Field experience = new TextField("experience", job.getExperience(), Field.Store.YES);
			Field education = new TextField("education", job.getEducation(), Field.Store.YES);
			Field salary = new TextField("salary", job.getSalary(), Field.Store.YES);
			Field createDate = new TextField("createDate",
					new SimpleDateFormat("yyyy-MM-dd").format(job.getCreateDate()), Field.Store.YES);

			document.add(id);
			document.add(cid);
			document.add(coid);
			document.add(name);
			document.add(catogoryName);
			document.add(companyName);
			document.add(city);
			document.add(nature);
			document.add(experience);
			document.add(education);
			document.add(salary);
			document.add(createDate);
			docList.add(document);
		}
		// Analyzer analyzer = new StandardAnalyzer();
		Analyzer analyzer = new IKAnalyzer();
		IndexWriterConfig cfg = new IndexWriterConfig(analyzer);
		// Directory directory =
		// FSDirectory.open(FileSystems.getDefault().getPath("G:\\lucene_index_file\\"));
		Directory directory = FSDirectory.open(FileSystems.getDefault().getPath("IndexOfSearcherEngine"));
		IndexWriter writer = new IndexWriter(directory, cfg);
		writer.deleteAll();
		for (Document doc : docList) {
			writer.addDocument(doc);
		}
		writer.close();
		System.out.println("索引已经生成");
	}
	
	 public static List<JobDto> doSearch(String keyword,Page page) {
		if(keyword=="")
			return null;
		
		 boolean flag=false;
		  for(int i=0;i<keyword.length();i++) {
		     if(keyword.charAt(i)!=' ') {
		        flag=true;
		     }
		  }
		  if(!flag) {
		   return null;
		  }
		  
		Analyzer analyzer = new IKAnalyzer();//使用IKAnalyzer作为中文分词器
		QueryParser parser = new QueryParser("name", analyzer);
		
		Query query=null;
		try {
			query = parser.parse(keyword);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//返回一个DTO比较好，
		List<JobDto> jobDtos = new ArrayList<JobDto>();//这是jobDtos的数组
		try {
			//Directory directory = FSDirectory.open(FileSystems.getDefault().getPath("G:\\lucene_index_file\\"));
			Directory directory = FSDirectory.open(FileSystems.getDefault().getPath("IndexOfSearcherEngine"));
			IndexReader reader = DirectoryReader.open(directory);
			IndexSearcher searcher = new IndexSearcher(reader);
			TopDocs topDocs = searcher.search(query, 1000);//设置最多展示1000条信息（如果有1000条）
			int count = topDocs.totalHits;
			System.out.println("匹配的记录总数："+count);
			page.setTotal(count);//设置总记录数
			ScoreDoc[] scoreDocs = topDocs.scoreDocs;
			int end = (page.getStart()+page.getCount())>count?count:(page.getStart()+page.getCount());
			for(int i=page.getStart();i<end;i++) {
				System.out.println(i);
				int docId = scoreDocs[i].doc;
				System.out.println(scoreDocs[i].score);
				Document doc = searcher.doc(docId);
				JobDto jobDto = new JobDto();//新建的岗位对象
				jobDto.setId(Integer.parseInt(doc.get("id")));
				jobDto.setCid(Integer.parseInt(doc.get("cid")));
				jobDto.setCoid(Integer.parseInt(doc.get("coid")));
				jobDto.setName(doc.get("name"));
				jobDto.setCategoryName(doc.get("categoryName"));
				jobDto.setCompanyName(doc.get("companyName"));
				jobDto.setCity(doc.get("city"));
				jobDto.setNature(doc.get("nature"));
				jobDto.setExperience(doc.get("experience"));
				jobDto.setEducation(doc.get("education"));
				jobDto.setSalary(doc.get("salary"));
				jobDto.setCreateDate(doc.get("createDate"));
				jobDtos.add(jobDto);
			}
			reader.close();
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		return jobDtos;
	}
}
