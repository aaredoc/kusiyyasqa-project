package com.kusiyyasqa.app.controller;

@RestController
@RequestMapping("api/v1/aportante")
public class AportanteController {

    private final AportanteService aportanteService;

    @Autowired
    public AportanteController(AportanteService AportanteService){
        this.aportanteService = AportanteService;
    }

    @GetMapping
    public List<AportanteDTO> findAll(){
        return this.aportanteService.findAll();
    }

    @GetMapping("/{id}")
    public AportanteDTO findById(@PathVariable(value = "id") Long id){
        return this.aportanteService.findById(id);
    }

    @PostMapping
    public AportanteDTO save(@RequestBody AportanteDTO aportanteDTO){
        return this.aportanteService.save(aportanteDTO);
    }

    @PutMapping
    public AportanteDTO update(@RequestBody AportanteDTO aportanteDTO){
        return this.aportanteService.update(aportanteDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        this.aportanteService.delete(id);
    }
}
 