package com.app.controller;
import com.app.attore.*;
import com.app.util.ClsnRownPages;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class MainController {   
    @Autowired
    private AttoreService attoreService;

    class ClsDati extends ArrayList<Object> {
		public ClsDati() {}
		public ClsDati(Object d) {
			this.add(d);
		}
    }
    
    
    @RequestMapping("/")
    String home() {
        return "inserire listAttori nell'url per elenco completo oppure attore/1 ";
    }

    @GetMapping("attore/{codAttore}")
    public ResponseEntity<Attore> getAttore(@PathVariable("codAttore") Long codAttore){
        Attore attore =attoreService.getAttore(codAttore);
        return new ResponseEntity<Attore>(attore,HttpStatus.OK);
    }

    @GetMapping("listAttori")
    public List<Attore> getAttori(){
        return attoreService.getAttori();
    }
    
    @GetMapping("getDataRows")
    public List<Attore> getData(@RequestParam String tableName,
            					@RequestParam Integer pageIndex,   
            					@RequestParam Integer pageSize){
        return attoreService.getData(tableName,pageIndex, pageSize);
    }
    
    @GetMapping("getnRowsnPages")
    public ClsnRownPages getnRowsnPages(@RequestParam String tableName,
            							@RequestParam Integer pageIndex,   
        								@RequestParam Integer pageSize){
        return attoreService.getnRowsnPages(tableName,pageIndex, pageSize);
    }
    @GetMapping("getData")
    public ClsDati clsDati(@RequestParam String tableName,
    	            	   @RequestParam Integer pageIndex,   
        				   @RequestParam Integer pageSize){
    	ClsDati s1 = new ClsDati();
    	
    	s1.add(attoreService.getData(tableName,pageIndex, pageSize));
    	s1.add(new ClsDati());
    	s1.add(new ClsDati(attoreService.getnRowsnPages(tableName,pageIndex, pageSize)));
        return s1;
    }

    @PutMapping("ModAttore")
    public ResponseEntity<String> modAttore(@RequestParam Long codAttore,
                                            @RequestParam String nome,   
                                            @RequestParam Long annoNascita,
                                            @RequestParam String nazionalita
        ) {
    	System.out.println(nome);
        Attore attore=new Attore(codAttore,nome,annoNascita,nazionalita);
		attoreService.modAttore(attore);
		
		
        String json= "{\"status\":  \" 200 \", \"Message\": \"Ins OK\",\"data\":\"  \"}";
        System.out.println(json);
        return new ResponseEntity<String>(json,HttpStatus.OK);
    }
    
    @DeleteMapping("delAttore")
    public ResponseEntity<String> delAttore(@RequestParam Long codAttore) {
		attoreService.delAttore(codAttore);
        String json= "{\"status\":  \" 200 \", \"Message\": \"Del OK\"}";
        return new ResponseEntity<String>(json,HttpStatus.OK);
    }
}