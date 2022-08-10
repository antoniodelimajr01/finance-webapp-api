package com.financewebapp.api.controllers;

import com.financewebapp.api.dto.EntryDTO;
import com.financewebapp.api.model.Entry;
import com.financewebapp.api.service.EntryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/entry")
public class EntryController {
    @Autowired
    private EntryService service;
    private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping("/list")
    public ResponseEntity<List<EntryDTO>> getEntries() {
        LOG.info("Getting List of Entry");
        return ResponseEntity.ok(service.getEntries());
    }

    @PostMapping
    public ResponseEntity<EntryDTO> post(@RequestBody Entry entry) {
        LOG.info("Posting item of Entry");
        EntryDTO e = service.insert(entry);

        return e != null ? ResponseEntity.created(null).build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntryDTO> put(@PathVariable("id") Long id, @RequestBody Entry entry) {
        LOG.info("Puting item of Entry");
        entry.setEntryId(id);
        EntryDTO e = service.update(entry, id);

        return e != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EntryDTO> delete(@PathVariable("id") Long id) {
        LOG.info("Deleting item of Entry");
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EntryDTO> patch(@PathVariable("id") Long id, @RequestBody Entry entry) {
        LOG.info("Patching item of Entry");
        EntryDTO e = service.patch(id, entry);

        return e != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
