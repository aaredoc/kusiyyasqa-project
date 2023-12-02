package com.kusiyyasqa.app.controller;
@RestController
@RequestMapping("api/v1/donativo")
public class DonativoController {
    
    private final DonativoService donativoService;
    
    @Autowired
    public DonativoController(DonativoService donativoService) {
        this.donativoService = donativoService;
    }

    @GetMapping
    public List<DonativoDTO>findAll(){
        return this.donativoService.findAll();
    }

    @GetMapping("/{id}")
    public DonativoDTO findById(@PathVariable(value = "id") Long id){
        return this.donativoService.findById(id);
    }

    @PostMapping
    public DonativoDTO save(@RequestBody DonativoDTO donativoDTO){
        return this.donativoService.save(donativoDTO);
    }

    @PutMapping
    public DonativoDTO update(@RequestBody DonativoDTO donativoDTO){
        return this.donativoService.update(donativoDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        this.donativoService.delete(id);
    }
}
