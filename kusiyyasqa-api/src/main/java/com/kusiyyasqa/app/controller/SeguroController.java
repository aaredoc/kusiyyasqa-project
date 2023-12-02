package com.kusiyyasqa.app.controller;

@RestController
@RequestMapping("api/v1/seguro")
public class SeguroController {
    
    private final SeguroService seguroService;
    
    @Autowired
    public SeguroController(SeguroService seguroService) {
        this.seguroService = seguroService;
    }

    @GetMapping
    public List<SeguroDTO>findAll(){
        return this.seguroService.findAll();
    }

    @GetMapping("/{id}")
    public SeguroDTO findById(@PathVariable(value = "id") Long id){
        return this.seguroService.findById(id);
    }

    @PostMapping
    public SeguroDTO save(@RequestBody SeguroDTO seguroDTO){
        return this.seguroService.save(seguroDTO);
    }

    @PutMapping
    public SeguroDTO update(@RequestBody SeguroDTO seguroDTO){
        return this.seguroService.update(seguroDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        this.seguroService.delete(id);
    }
}
