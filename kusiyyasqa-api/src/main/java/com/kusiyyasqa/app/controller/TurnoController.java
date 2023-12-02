package com.kusiyyasqa.app.controller;

@RestController
@RequestMapping("api/v1/turno")
public class TurnoController {
    
    private final TurnoService turnoService;
    
    @Autowired
    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping
    public List<TurnoDTO>findAll(){
        return this.turnoService.findAll();
    }

    @GetMapping("/{id}")
    public TurnoDTO findById(@PathVariable(value = "id") Long id){
        return this.turnoService.findById(id);
    }

    @PostMapping
    public TurnoDTO save(@RequestBody TurnoDTO turnoDTO){
        return this.turnoService.save(turnoDTO);
    }

    @PutMapping
    public TurnoDTO update(@RequestBody TurnoDTO turnoDTO){
        return this.turnoService.update(turnoDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        this.turnoService.delete(id);
    }
}
