package com.kusiyyasqa.app.controller;

@RestController
@RequestMapping("api/v1/parentesco")
public class ParentescoController {

    private final ParentescoService parentescoService;
    
    @Autowired
    public ParentescoController(ParentescoService parentescoService) {
        this.parentescoService = parentescoService;
    }

    @GetMapping
    public List<ParentescoDTO>findAll(){
        return this.parentescoService.findAll();
    }

    @GetMapping("/{id}")
    public ParentescoDTO findById(@PathVariable(value = "id") Long id){
        return this.parentescoService.findById(id);
    }

    @PostMapping
    public ParentescoDTO save(@RequestBody ParentescoDTO parentescoDTO){
        return this.parentescoService.save(parentescoDTO);
    }

    @PutMapping
    public ParentescoDTO update(@RequestBody ParentescoDTO parentescoDTO){
        return this.parentescoService.update(parentescoDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        this.parentescoService.delete(id);
    }
}
