package com.kusiyyasqa.app.controller;

@RestController
@RequestMapping("api/v1/participacion")
public class ParticipacionController {
    
    private final ParticipacionService participacionService;
    
    @Autowired
    public ParticipacionController(ParticipacionService participacionService) {
        this.participacionService = participacionService;
    }

    @GetMapping
    public List<ParticipacionDTO>findAll(){
        return this.participacionService.findAll();
    }

    @GetMapping("/{id}")
    public ParticipacionDTO findById(@PathVariable(value = "id") Long id){
        return this.participacionService.findById(id);
    }

    @PostMapping
    public ParticipacionDTO save(@RequestBody ParticipacionDTO participacionDTO){
        return this.participacionService.save(participacionDTO);
    }

    @PutMapping
    public ParticipacionDTO update(@RequestBody ParticipacionDTO participacionDTO){
        return this.participacionService.update(participacionDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        this.participacionService.delete(id);
    }
}
