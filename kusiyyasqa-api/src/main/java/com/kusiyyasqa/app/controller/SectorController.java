package com.kusiyyasqa.app.controller;

@RestController
@RequestMapping("api/v1/sector")
public class SectorController {

    private final SectorService sectorService;
    
    @Autowired
    public SectorController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @GetMapping
    public List<SectorDTO>findAll(){
        return this.sectorService.findAll();
    }

    @GetMapping("/{id}")
    public SectorDTO findById(@PathVariable(value = "id") Long id){
        return this.sectorService.findById(id);
    }

    @PostMapping
    public SectorDTO save(@RequestBody SectorDTO sectorDTO){
        return this.sectorService.save(sectorDTO);
    }

    @PutMapping
    public SectorDTO update(@RequestBody SectorDTO sectorDTO){
        return this.sectorService.update(sectorDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        this.sectorService.delete(id);
    }

}
