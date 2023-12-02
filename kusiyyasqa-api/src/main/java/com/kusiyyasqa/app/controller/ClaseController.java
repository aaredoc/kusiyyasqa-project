package com.kusiyyasqa.app.controller;

@RestController
@RequestMapping("api/v1/clase")
public class ClaseController {

    private final ClaseService claseService;
    
    @Autowired
    public ClaseController(ClaseService claseService) {
        this.claseService = claseService;
    }

    @GetMapping
    public List<ClaseDTO>findAll(){
        return this.claseService.findAll();
    }

    @GetMapping("/{id}")
    public ClaseDTO findById(@PathVariable(value = "id") Long id){
        return this.claseService.findById(id);
    }

    @PostMapping
    public ClaseDTO save(@RequestBody ClaseDTO claseDTO){
        return this.claseService.save(claseDTO);
    }

    @PutMapping
    public ClaseDTO update(@RequestBody ClaseDTO claseDTO){
        return this.claseService.update(claseDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        this.claseService.delete(id);
    }
}
