package com.kusiyyasqa.app.controller;

@RestController
@RequestMapping("api/v1/zona")
public class ZonaController {
    
    private final ZonaService zonaService;
    
    @Autowired
    public ZonaController(ZonaService zonaService) {
        this.zonaService = zonaService;
    }

    @GetMapping
    public List<ZonaDTO>findAll(){
        return this.zonaService.findAll();
    }

    @GetMapping("/{id}")
    public ZonaDTO findById(@PathVariable(value = "id") Long id){
        return this.zonaService.findById(id);
    }

    @PostMapping
    public ZonaDTO save(@RequestBody ZonaDTO zonaDTO){
        return this.zonaService.save(zonaDTO);
    }

    @PutMapping
    public ZonaDTO update(@RequestBody ZonaDTO zonaDTO){
        return this.zonaService.update(zonaDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        this.zonaService.delete(id);
    }
}
