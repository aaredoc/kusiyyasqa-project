package com.kusiyyasqa.app.controller;

@RestController
@RequestMapping("api/v1/beneficiado")
public class BeneficiadoController {

    private final BeneficiadoService beneficiadoService;

    @Autowired
    public BeneficiadoController(BeneficiadoService beneficiadoService){
        this.beneficiadoService = beneficiadoService;
    }

    @GetMapping
    public List<BeneficiadoDTO> findAll(){
        return this.beneficiadoService.findAll();
    }

    @GetMapping("/{id}")
    public BeneficiadoDTO findById(@PathVariable(value = "id") Long id){
        return this.beneficiadoService.findById(id);
    }

    @PostMapping
    public BeneficiadoDTO save(@RequestBody BeneficiadoDTO beneficiadoDTO){
        return this.beneficiadoService.save(beneficiadoDTO);
    }

    @PutMapping
    public BeneficiadoDTO update(@RequestBody BeneficiadoDTO beneficiadoDTO){
        return this.beneficiadoService.update(beneficiadoDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        return this.beneficiadoService.delete(id);
    }
}
