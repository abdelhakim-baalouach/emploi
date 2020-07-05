    <script type="text/javascript" src="../resources/assets/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../resources/assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../resources/assets/js/jquery.slimscroll.js"></script>
    <script type="text/javascript" src="../resources/assets/js/select2.min.js"></script>
    <script type="text/javascript" src="../resources/assets/js/moment.min.js"></script>
    <script type="text/javascript" src="../resources/assets/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="../resources/assets/plugins/morris/morris.min.js"></script>
    <script type="text/javascript" src="../resources/assets/plugins/raphael/raphael-min.js"></script>
    <script type="text/javascript" src="../resources/assets/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="../resources/assets/js/dataTables.bootstrap.min.js"></script>
    <script type="text/javascript" src="../resources/assets/js/select2.min.js"></script>
    <script type="text/javascript" src="../resources/assets/js/bootstrap-clockpicker.min.js"></script>
    <script type="text/javascript" src="../resources/assets/js/highlight.min.js"></script>
    <script type="text/javascript" src="../resources/assets/js/app.js"></script>
    <script>
        $(document).ready(function() {
        	$('#dataHoraire').DataTable( {
                 "language": {
                     "decimal":        "",
                     "emptyTable":     "Aucune donnée disponible dans la table",
                     "infoFiltered":   "(filtré du nombre total d'entrées)",
                     "infoEmpty":      "Affiche 0 à 0 de 0 entrées",
                     "lengthMenu":     "",
                     "loadingRecords": "Chargement...",
                     "processing":     "En traitement...",
                     "search":         "Chercher :",
                     "zeroRecords":    "Aucun enregistrements correspondants trouvés",
                     "paginate": {
                         "first":      "Premier",
                         "last":       "Dernier",
                         "next":       "Suivant",
                         "previous":   "Précédent"
                     },
                     "aria": {
                         "sortAscending":  ": Activer pour trier la colonne par ordre croissant",
                         "sortDescending": ": Activer pour trier la colonne par ordre décroissant"
                     }
                 }
             } );
        	
        	
        	
        	
            $('#dataTable').DataTable({
                "language": {
                    "decimal":        "",
                    "emptyTable":     "Aucune donnée disponible dans la table",
                    "infoFiltered":   "(filtré du nombre total d'entrées)",
                    "infoEmpty":      "Affiche 0 à 0 de 0 entrées",
                    "lengthMenu":     "",
                    "loadingRecords": "Chargement...",
                    "processing":     "En traitement...",
                    "search":         "Chercher :",
                    "zeroRecords":    "Aucun enregistrements correspondants trouvés",
                    "paginate": {
                        "first":      "Premier",
                        "last":       "Dernier",
                        "next":       "Suivant",
                        "previous":   "Précédent"
                    },
                    "aria": {
                        "sortAscending":  ": Activer pour trier la colonne par ordre croissant",
                        "sortDescending": ": Activer pour trier la colonne par ordre décroissant"
                    }
                }
            });
            $('#dataTable2').DataTable({
                "language": {
                    "decimal":        "",
                    "emptyTable":     "Aucune donnée disponible dans la table",
                    "infoFiltered":   "(filtré du nombre total d'entrées)",
                    "infoEmpty":      "Affiche 0 à 0 de 0 entrées",
                    "lengthMenu":     "",
                    "loadingRecords": "Chargement...",
                    "processing":     "En traitement...",
                    "search":         "Chercher :",
                    "zeroRecords":    "Aucun enregistrements correspondants trouvés",
                    "paginate": {
                        "first":      "Premier",
                        "last":       "Dernier",
                        "next":       "Suivant",
                        "previous":   "Précédent"
                    },
                    "aria": {
                        "sortAscending":  ": Activer pour trier la colonne par ordre croissant",
                        "sortDescending": ": Activer pour trier la colonne par ordre décroissant"
                    }
                }
            });
            $('#dataMesure').DataTable( {
                "order": [[ 6, "desc" ]],
                "language": {
                    "decimal":        "",
                    "emptyTable":     "Aucune donnée disponible dans la table",
                    "infoFiltered":   "(filtré du nombre total d'entrées)",
                    "infoEmpty":      "Affiche 0 à 0 de 0 entrées",
                    "lengthMenu":     "",
                    "loadingRecords": "Chargement...",
                    "processing":     "En traitement...",
                    "search":         "Chercher :",
                    "zeroRecords":    "Aucun enregistrements correspondants trouvés",
                    "paginate": {
                        "first":      "Premier",
                        "last":       "Dernier",
                        "next":       "Suivant",
                        "previous":   "Précédent"
                    },
                    "aria": {
                        "sortAscending":  ": Activer pour trier la colonne par ordre croissant",
                        "sortDescending": ": Activer pour trier la colonne par ordre décroissant"
                    }
                }
            } );
            $('#dataMesureApres').DataTable( {
                "order": [[ 11, "desc" ]],
                "language": {
                    "decimal":        "",
                    "emptyTable":     "Aucune donnée disponible dans la table",
                    "infoFiltered":   "(filtré du nombre total d'entrées)",
                    "infoEmpty":      "Affiche 0 à 0 de 0 entrées",
                    "lengthMenu":     "",
                    "loadingRecords": "Chargement...",
                    "processing":     "En traitement...",
                    "search":         "Chercher :",
                    "zeroRecords":    "Aucun enregistrements correspondants trouvés",
                    "paginate": {
                        "first":      "Premier",
                        "last":       "Dernier",
                        "next":       "Suivant",
                        "previous":   "Précédent"
                    },
                    "aria": {
                        "sortAscending":  ": Activer pour trier la colonne par ordre croissant",
                        "sortDescending": ": Activer pour trier la colonne par ordre décroissant"
                    }
                }
            } );
            $('#dataOrdonnance').DataTable( {
                "order": [[ 3, "desc" ]],
                "language": {
                    "decimal":        "",
                    "emptyTable":     "Aucune donnée disponible dans la table",
                    "infoFiltered":   "(filtré du nombre total d'entrées)",
                    "infoEmpty":      "Affiche 0 à 0 de 0 entrées",
                    "lengthMenu":     "",
                    "loadingRecords": "Chargement...",
                    "processing":     "En traitement...",
                    "search":         "Chercher :",
                    "zeroRecords":    "Aucun enregistrements correspondants trouvés",
                    "paginate": {
                        "first":      "Premier",
                        "last":       "Dernier",
                        "next":       "Suivant",
                        "previous":   "Précédent"
                    },
                    "aria": {
                        "sortAscending":  ": Activer pour trier la colonne par ordre croissant",
                        "sortDescending": ": Activer pour trier la colonne par ordre décroissant"
                    }
                }
            } );
            
              $('#dataCons2').DataTable( {
                "order": [[ 4, "desc" ]],
                "language": {
                    "decimal":        "",
                    "emptyTable":     "Aucune donnée disponible dans la table",
                    "infoFiltered":   "(filtré du nombre total d'entrées)",
                    "infoEmpty":      "Affiche 0 à 0 de 0 entrées",
                    "lengthMenu":     "",
                    "loadingRecords": "Chargement...",
                    "processing":     "En traitement...",
                    "search":         "Chercher :",
                    "zeroRecords":    "Aucun enregistrements correspondants trouvés",
                    "paginate": {
                        "first":      "Premier",
                        "last":       "Dernier",
                        "next":       "Suivant",
                        "previous":   "Précédent"
                    },
                    "aria": {
                        "sortAscending":  ": Activer pour trier la colonne par ordre croissant",
                        "sortDescending": ": Activer pour trier la colonne par ordre décroissant"
                    }
                }
            } );

            $(".select2etab").select2({
                width: "100%"
            });
            $('.clockpicker').clockpicker();
        } );
    </script>
</body>

</html>