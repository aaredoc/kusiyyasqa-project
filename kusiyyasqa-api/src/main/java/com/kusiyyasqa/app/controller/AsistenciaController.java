package com.kusiyyasqa.app.controller;

@RestController
@RequestMapping("api/v1/asistencia")
public class AsistenciaController {

    private final AsistenciaService aistenciaService;

    @Autowired
    public AsistenciaController(AsistenciaService aistenciaService){
        this.asistenciaService = asistenciaService;
    }

    @GetMapping
    public List<AsistenciaDTO> findAll(){
        return this.asistenciaService.findAll();
    }

    @GetMapping("/{id}")
    public AsistenciaDTO findById(@PathVariable(value = "id") Long id){
        return this.asistenciaService.findById(id);
    }

    @PostMapping
    public AsistenciaDTO save(@RequestBody AsistenciaDTO asistenciaDTO){
        return this.asistenciaService.save(asistenciaDTO);
    }
    
    @PutMapping
    public AsistenciaDTO update(@RequestBody AsistenciaDTO asistenciaDTO){
        return this.asistenciaService.update(asistenciaDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        return this.asistenciaService.delete(id);
    }
}
