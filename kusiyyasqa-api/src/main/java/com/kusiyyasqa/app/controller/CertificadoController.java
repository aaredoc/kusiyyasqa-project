package com.kusiyyasqa.app.controller;


@RestController
@RequestMapping("api/v1/certificado")
public class CertificadoController {

    private final CertificadoService certificadoService;
    
    @Autowired
    public CertificadoController(CertificadoService certificadoService) {
        this.certificadoService = certificadoService;
    }

    @GetMapping
    public List<CertificadoDTO>findAll(){
        return this.certificadoService.findAll();
    }

    @GetMapping("/{id}")
    public CertificadoDTO findById(@PathVariable(value = "id") Long id){
        return this.certificadoService.findById(id);
    }

    @PostMapping
    public CertificadoDTO save(@RequestBody CertificadoDTO certificadoDTO){
        return this.certificadoService.save(certificadoDTO);
    }

    @PutMapping
    public CertificadoDTO update(@RequestBody CertificadoDTO certificadoDTO){
        return this.certificadoService.update(certificadoDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        this.certificadoService.delete(id);
    }
}
