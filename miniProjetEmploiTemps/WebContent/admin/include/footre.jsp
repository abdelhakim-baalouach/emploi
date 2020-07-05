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
                     "emptyTable":     "Aucune donn�e disponible dans la table",
                     "infoFiltered":   "(filtr� du nombre total d'entr�es)",
                     "infoEmpty":      "Affiche 0 � 0 de 0 entr�es",
                     "lengthMenu":     "",
                     "loadingRecords": "Chargement...",
                     "processing":     "En traitement...",
                     "search":         "Chercher :",
                     "zeroRecords":    "Aucun enregistrements correspondants trouv�s",
                     "paginate": {
                         "first":      "Premier",
                         "last":       "Dernier",
                         "next":       "Suivant",
                         "previous":   "Pr�c�dent"
                     },
                     "aria": {
                         "sortAscending":  ": Activer pour trier la colonne par ordre croissant",
                         "sortDescending": ": Activer pour trier la colonne par ordre d�croissant"
                     }
                 }
             } );
        	
        	
        	
        	
            $('#dataTable').DataTable({
                "language": {
                    "decimal":        "",
                    "emptyTable":     "Aucune donn�e disponible dans la table",
                    "infoFiltered":   "(filtr� du nombre total d'entr�es)",
                    "infoEmpty":      "Affiche 0 � 0 de 0 entr�es",
                    "lengthMenu":     "",
                    "loadingRecords": "Chargement...",
                    "processing":     "En traitement...",
                    "search":         "Chercher :",
                    "zeroRecords":    "Aucun enregistrements correspondants trouv�s",
                    "paginate": {
                        "first":      "Premier",
                        "last":       "Dernier",
                        "next":       "Suivant",
                        "previous":   "Pr�c�dent"
                    },
                    "aria": {
                        "sortAscending":  ": Activer pour trier la colonne par ordre croissant",
                        "sortDescending": ": Activer pour trier la colonne par ordre d�croissant"
                    }
                }
            });
            $('#dataTable2').DataTable({
                "language": {
                    "decimal":        "",
                    "emptyTable":     "Aucune donn�e disponible dans la table",
                    "infoFiltered":   "(filtr� du nombre total d'entr�es)",
                    "infoEmpty":      "Affiche 0 � 0 de 0 entr�es",
                    "lengthMenu":     "",
                    "loadingRecords": "Chargement...",
                    "processing":     "En traitement...",
                    "search":         "Chercher :",
                    "zeroRecords":    "Aucun enregistrements correspondants trouv�s",
                    "paginate": {
                        "first":      "Premier",
                        "last":       "Dernier",
                        "next":       "Suivant",
                        "previous":   "Pr�c�dent"
                    },
                    "aria": {
                        "sortAscending":  ": Activer pour trier la colonne par ordre croissant",
                        "sortDescending": ": Activer pour trier la colonne par ordre d�croissant"
                    }
                }
            });
            $('#dataMesure').DataTable( {
                "order": [[ 6, "desc" ]],
                "language": {
                    "decimal":        "",
                    "emptyTable":     "Aucune donn�e disponible dans la table",
                    "infoFiltered":   "(filtr� du nombre total d'entr�es)",
                    "infoEmpty":      "Affiche 0 � 0 de 0 entr�es",
                    "lengthMenu":     "",
                    "loadingRecords": "Chargement...",
                    "processing":     "En traitement...",
                    "search":         "Chercher :",
                    "zeroRecords":    "Aucun enregistrements correspondants trouv�s",
                    "paginate": {
                        "first":      "Premier",
                        "last":       "Dernier",
                        "next":       "Suivant",
                        "previous":   "Pr�c�dent"
                    },
                    "aria": {
                        "sortAscending":  ": Activer pour trier la colonne par ordre croissant",
                        "sortDescending": ": Activer pour trier la colonne par ordre d�croissant"
                    }
                }
            } );
            $('#dataMesureApres').DataTable( {
                "order": [[ 11, "desc" ]],
                "language": {
                    "decimal":        "",
                    "emptyTable":     "Aucune donn�e disponible dans la table",
                    "infoFiltered":   "(filtr� du nombre total d'entr�es)",
                    "infoEmpty":      "Affiche 0 � 0 de 0 entr�es",
                    "lengthMenu":     "",
                    "loadingRecords": "Chargement...",
                    "processing":     "En traitement...",
                    "search":         "Chercher :",
                    "zeroRecords":    "Aucun enregistrements correspondants trouv�s",
                    "paginate": {
                        "first":      "Premier",
                        "last":       "Dernier",
                        "next":       "Suivant",
                        "previous":   "Pr�c�dent"
                    },
                    "aria": {
                        "sortAscending":  ": Activer pour trier la colonne par ordre croissant",
                        "sortDescending": ": Activer pour trier la colonne par ordre d�croissant"
                    }
                }
            } );
            $('#dataOrdonnance').DataTable( {
                "order": [[ 3, "desc" ]],
                "language": {
                    "decimal":        "",
                    "emptyTable":     "Aucune donn�e disponible dans la table",
                    "infoFiltered":   "(filtr� du nombre total d'entr�es)",
                    "infoEmpty":      "Affiche 0 � 0 de 0 entr�es",
                    "lengthMenu":     "",
                    "loadingRecords": "Chargement...",
                    "processing":     "En traitement...",
                    "search":         "Chercher :",
                    "zeroRecords":    "Aucun enregistrements correspondants trouv�s",
                    "paginate": {
                        "first":      "Premier",
                        "last":       "Dernier",
                        "next":       "Suivant",
                        "previous":   "Pr�c�dent"
                    },
                    "aria": {
                        "sortAscending":  ": Activer pour trier la colonne par ordre croissant",
                        "sortDescending": ": Activer pour trier la colonne par ordre d�croissant"
                    }
                }
            } );
            
              $('#dataCons2').DataTable( {
                "order": [[ 4, "desc" ]],
                "language": {
                    "decimal":        "",
                    "emptyTable":     "Aucune donn�e disponible dans la table",
                    "infoFiltered":   "(filtr� du nombre total d'entr�es)",
                    "infoEmpty":      "Affiche 0 � 0 de 0 entr�es",
                    "lengthMenu":     "",
                    "loadingRecords": "Chargement...",
                    "processing":     "En traitement...",
                    "search":         "Chercher :",
                    "zeroRecords":    "Aucun enregistrements correspondants trouv�s",
                    "paginate": {
                        "first":      "Premier",
                        "last":       "Dernier",
                        "next":       "Suivant",
                        "previous":   "Pr�c�dent"
                    },
                    "aria": {
                        "sortAscending":  ": Activer pour trier la colonne par ordre croissant",
                        "sortDescending": ": Activer pour trier la colonne par ordre d�croissant"
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