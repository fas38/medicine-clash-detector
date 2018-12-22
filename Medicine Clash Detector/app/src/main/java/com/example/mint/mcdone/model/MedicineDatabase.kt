package com.example.mint.mcdone.model

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

//Pre-populated medicine database

@Database(entities = arrayOf(Medicine::class), version = 1)

abstract class MedicineDatabase : RoomDatabase(){
    abstract fun medicineDao(): MedicineDao

    companion object {

        @Volatile private var INSTANCE: MedicineDatabase? = null

        fun getInstance(context: Context): MedicineDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also{ INSTANCE = it}
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        MedicineDatabase::class.java, "medicine.db")
                        // prepopulate the database after onCreate was called
                        .addCallback(object : Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                // insert the data on the IO Thread
                                ioThread {
                                    getInstance(context).medicineDao().insertMedicine(PREPOPULATE_DATA)
                                }
                            }
                        })
                        .build()

        val PREPOPULATE_DATA = listOf(
                Medicine(1, "Ace", "Paracetamol", "Paracetamol,Aspirin", "kidney,liver"),
                Medicine(2, "Napa", "Paracetamol", "Paracetamol,Aspirin", "kidney,liver"),
                Medicine(3, "Neotack", "Ranitidine", "Ranitidine,Ketoconazole", ""),
                Medicine(4, "MaXpro", "Esomeprazole", "Esomeprazole,Ketoconazole", "Lactation"),
                Medicine(5, "Konadel", "Ketoconazole", "Ketoconazole,Ranitidine", "liver"),
                Medicine(6, "Abdorin", "Dicycloverine Hydrochloride", "Dicycloverine Hydrochloride", "glaucoma"),
                Medicine(7, "Dirin", "Dicycloverine Hydrochloride", "Dicycloverine Hydrochloride", "glaucoma"),
                Medicine(8, "Extals", "Riluzole", "Riluzole", "Hepatic disease,Neutropenia"),
                Medicine(9, "Flexicam", "Piroxicam", "Piroxicam,Anticoagulants", "gastro-intestinal ulceration,Severe heart failure"),
                Medicine(10, "Rheudene", "Piroxicam", "Piroxicam,Anticoagulants", "gastro-intestinal ulceration,Severe heart failure"),
                Medicine(11, "Cefnor", "Cefdinir", "Cefdinir", "allergy to the cephalosporin class of antibiotics"),
                Medicine(12, "Adinir", "Cefdinir", "Cefdinir", "allergy to the cephalosporin class of antibiotics"),
                Medicine(13, "ACI ORS Effervescent", "Oral Rehydration Salt", "none", "none"),
                Medicine(14, "Aquasol", "Oral Rehydration Salt", "none", "none"),
                Medicine(15, "Racedot", "Racecadotril", "Racecadotril", "fructose intolerance,saccharase-isomaltase deficiency,glucose-galactose malabsorption syndrome"),
                Medicine(16, "Racetril", "Racecadotril", "Racecadotril", "fructose intolerance,saccharase-isomaltase deficiency,glucose-galactose malabsorption syndrome"),
                Medicine(17, "Cardipro", "Atenolol", "Atenolol,Baclofen,Amiodarone", "Sick sinus syndrome,Cardiogenic shock,Hypotension,Severe asthma"),
                Medicine(18, "Lonet", "Atenolol", "Atenolol,Baclofen,Amiodarone", "Sick sinus syndrome,Cardiogenic shock,Hypotension,Severe asthma"),
                Medicine(19, "Acuren", "Hydrochlorothiazide", "Hydrochlorothiazide", "pregnancy,severe renal dysfunction,idiopathic angioneurotic oedema, Lapp lactase deficiency"),
                Medicine(20, "Hypezide", "Hydrochlorothiazide", "Hydrochlorothiazide", "pregnancy,severe renal dysfunction,idiopathic angioneurotic oedema, Lapp lactase deficiency"),
                Medicine(21, "Natsin", "Melatonin", "Melatonin,nifedipine,warfarin,corticosteroids", "LAPP lactase deficiency,galactose intolerance,autoimmune diseases"),
                Medicine(22, "Filfresh", "Melatonin", "Melatonin,nifedipine,warfarin,corticosteroids", "LAPP lactase deficiency,galactose intolerance,autoimmune diseases"),
                Medicine(23, "Altrip", "Almotriptan", "Almotriptan,ergotamine", "ischaemic heart disease,hypertension"),
                Medicine(24, "Almitan", "Almotriptan", "Almotriptan,ergotamine", "ischaemic heart disease,hypertension"),
                Medicine(25, "Furosemide", "Furosemide", "Furosemide,sulphonamides", "hypovolaemia,Addison's disease,breast feeding women"),
                Medicine(26, "Fusid", "Furosemide", "Furosemide,sulphonamides", "hypovolaemia,Addison's disease,breast feeding women"),
                Medicine(27, "Acupain", "Nefopam Hydrochloride", "Nefopam Hydrochloride,mono-amine-oxidase (MAO) inhibitors", "convulsive disorders,myocardial infarction"),
                Medicine(28, "Efopam", "Nefopam Hydrochloride", "Nefopam Hydrochloride,mono-amine-oxidase (MAO) inhibitors", "convulsive disorders,myocardial infarction"),
                Medicine(29, "Nimex", "Nimesulide", "Nimesulide", "GI bleeding,active peptic ulcer disease,severe renal and heart failure"),
                Medicine(30, "Nibid", "Nimesulide", "Nimesulide", "GI bleeding,active peptic ulcer disease,severe renal and heart failure"),
                Medicine(31, "A-Flox", "Flucloxacillin Sodium", "Flucloxacillin Sodium,Gentamycin sulphate,Streptomycin sulphate", "Penicillin allergy,Pregnancy,Lactation,Spirochaete infections"),
                Medicine(32, "A-Mycin", "Erythromycin", "Erythromycin,Digoxin,Theophylline", "Lactation,Allergy"),
                Medicine(33, "Abandi", "Albendazole", "Erythromycin,Theophylline,Anticoagulants,Albendazole", "Liver,Pregnancy"),
                Medicine(34, "Flavox", "Flavoxate Hydrochloride", "Flavoxate Hydrochloride,Albendazole", "Gastrointestinal,CNS,Hematologic"),
                Medicine(35, "Flexicam", "Piroxicam", "Piroxicam,Aspirin,NSAID", "Heart,Asthma"),
                Medicine(36, "D Aspirin", "Aspirin", "Piroxicam,Aspirin", "Reye's syndrome,Peptic Ulcer"),
                Medicine(37, "D-cough", "Dextromethorphan Hydrobromide", "Dextromethorphan Hydrobromide, Amiodarone, Fluoexetine, Quinidine, CNS depressants and Monoamine oxidase", "smoking, asthma, or emphysema, or a cough that is productive (produces sputum or phlegm)"),
                Medicine(38, "Davycal", "Calcium Orotate Dihydrate", "Calcium Orotate Dihydrate,bisphosphonates, quinolone antibiotics, tetracycline antibiotics, levothyroxine,phenytoin,tiludronate disodium", "Allergy,kidney stone,kidney disease"),
                Medicine(39, "Dapsone", "Dapsone", "Dapsone,rifampicin", "Hypersensitivity,Anaemia,Porphyria"),
                Medicine(40, "Haemoplus", "Ferrous Sulphate+Folic Acid+Zinc Sulphate", "Ferrous Sulphate+Folic Acid+Zinc Sulphate", "Hypersensitivity,Anaemia"),
                Medicine(41, "Halazone", "Halazone", "Halazone,Dermatitis,Rhinitis,Conjunctivitis", "Hypersensitivity,Anaemia"),
                Medicine(42, "E-Cap", "Vitamin E", "Vitamin E", ""),
                Medicine(43, "Ecosprin", "Aspirin", "Piroxicam,Aspirin", "Reye's syndrome,Peptic Ulcer"),
                Medicine(44, "Maxidim", "Ceftazidime Pentahydrate", "Ceftazidime Pentahydrate,antibiotics", "hypersensitivity"),
                Medicine(45, "Maxical", "Calcium Carbonate", "Calcium Carbonate,vitamin D", "Hypersensitivity,Hypercalcemia"),
                Medicine(46, "Z Antacid", "Aluminium Hydroxide + Magnesium Hydroxide", "Aluminium Hydroxide + Magnesium Hydroxide,Tetracycline", "Hypophosphataemia"),
                Medicine(47, "Zactrol", "Famotidine", "Famotidine", ""),
                Medicine(48, "Zadifen", "Ketotifen Fumarate", "Ketotifen Fumarate,Antidiabetic", "Pregnancy,Lactation"),
                Medicine(49, "Zaft", "Zafirlukast", "Zafirlukast", "Hypersensitivity,Pregnancy,Lactation"),
                Medicine(50, "Acin", "Ranitidine", "Ranitidine,Antacids,Propantheline bromide", "Hypersensitivity,Lactation"),
                Medicine(51, "Acefra", "Cephradine", "Cephradine,Probenecid", "Hypersensitivity"),
                Medicine(52, "Acelex", "Cephalexin", "Cephalexin", "Hypersensitivity,Lactation"),
                Medicine(53, "Azyth", "Azithromycin", "Azithromycin,Antacids,Histamines,Digoxin,Cyclosporin", "Hypersensitivity,Lactation"),
                Medicine(54, "Azitra", "Azithromycin", "Azithromycin,Antacids,Histamines,Digoxin,Cyclosporin", "Hypersensitivity,Lactation"),
                Medicine(55, "Azix", "Azithromycin", "Azithromycin,Antacids,Histamines,Digoxin,Cyclosporin", "Hypersensitivity,Lactation"),
                Medicine(56, "Labeta", "Labetalol Hydrochloride", "Labetalol Hydrochloride,verapamil,diltiazem,halothane", "asthma,heart"),
                Medicine(57, "Lansec", "Lansoprazole", "Lansoprazole", "hypersensitivity"),
                Medicine(58, "Lanz", "Lansoprazole", "Lansoprazole", "hypersensitivity"),
                Medicine(59, "Lansogut", "Lansoprazole", "Lansoprazole", "hypersensitivity"),
                Medicine(60, "Lantus SoloStar", "Insulin Glargine", "Insulin Glargine,oral anti-diabetic products, angiotensin converting enzyme (ACE) inhibitors, disopyramide, fibrates, fluoxetine, monoamine oxidase inhibitors, propoxyphene, pentoxifylline, salicylates and sulfonamide antibiotics", "hypersensitivity,insulin glargine"),
                Medicine(61, "Lazide", "Gliclazide", "Gliclazide,barbiturates,corticosteroides,oral contraceptive", "pregnancy,lactation"),
                Medicine(62, "Datril", "Gliclazide", "Gliclazide,barbiturates,corticosteroides,oral contraceptive", "pregnancy,lactation"),
                Medicine(63, "Dela", "Gliclazide", "Gliclazide,barbiturates,corticosteroides,oral contraceptive", "pregnancy,lactation"),
                Medicine(64, "Claz", "Gliclazide", "Gliclazide,barbiturates,corticosteroides,oral contraceptive", "pregnancy,lactation"),
                Medicine(65, "Gide", "Gliclazide", "Gliclazide,barbiturates,corticosteroides,oral contraceptive", "pregnancy,lactation"),
                Medicine(66, "Luretic", "Torasemide", "Torasemide,amphotercin B,corticosteroid", "diabetes,gout,hypotension,liver,anuric,hypersensitive"),
                Medicine(67, "Ditec", "Torasemide", "Torasemide,amphotercin B,corticosteroid", "diabetes,gout,hypotension,liver,anuric,hypersensitive"),
                Medicine(68, "Dytor", "Torasemide", "Torasemide,amphotercin B,corticosteroid", "diabetes,gout,hypotension,liver,anuric,hypersensitive"),
                Medicine(69, "Dilast", "Torasemide", "Torasemide,amphotercin B,corticosteroid", "diabetes,gout,hypotension,liver,anuric,hypersensitive"),
                Medicine(70, "Tormed", "Torasemide", "Torasemide,amphotercin B,corticosteroid", "diabetes,gout,hypotension,liver,anuric,hypersensitive"),
                Medicine(71, "Ucrafate", "Sucralfate", "Sucralfate,Tetracycline", ""),
                Medicine(72, "Antepsin", "Sucralfate", "Sucralfate,Tetracycline", ""),
                Medicine(73, "Gastronic", "Sucralfate", "Sucralfate,Tetracycline", ""),
                Medicine(74, "Ulsec", "Sucralfate", "Sucralfate,Tetracycline", ""),
                Medicine(75, "Sucralet", "Sucralfate", "Sucralfate,Tetracycline", ""),
                Medicine(76, "Tetracycline", "Tetracycline", "Sucralfate,Tetracycline", "hypersensitivity,lupus erythematosus,pregnancy,lactation"),
                Medicine(77, "A Tetra", "Tetracycline", "Sucralfate,Tetracycline", "hypersensitivity,lupus erythematosus,pregnancy,lactation"),
                Medicine(78, "Atron", "Tetracycline", "Sucralfate,Tetracycline", "hypersensitivity,lupus erythematosus,pregnancy,lactation"),
                Medicine(79, "Decacycline", "Tetracycline", "Sucralfate,Tetracycline", "hypersensitivity,lupus erythematosus,pregnancy,lactation"),
                Medicine(80, "Halmacycline", "Tetracycline", "Sucralfate,Tetracycline", "hypersensitivity,lupus erythematosus,pregnancy,lactation"),
                Medicine(81, "Ubilon", "Tibolone", "Tibolone,anticoagulants,warfarin", "Porphyria,pregnancy,lactation,hyperplasia,malignant tumour,Migraine,Epilepsy,Asthma"),
                Medicine(82, "Lenea", "Tibolone", "Tibolone,anticoagulants,warfarin", "Porphyria,pregnancy,lactation,hyperplasia,malignant tumour,Migraine,Epilepsy,Asthma"),
                Medicine(83, "Menobon", "Tibolone", "Tibolone,anticoagulants,warfarin", "Porphyria,pregnancy,lactation,hyperplasia,malignant tumour,Migraine,Epilepsy,Asthma"),
                Medicine(84, "Tivion", "Tibolone", "Tibolone,anticoagulants,warfarin", "Porphyria,pregnancy,lactation,hyperplasia,malignant tumour,Migraine,Epilepsy,Asthma"),
                Medicine(85, "Tibo", "Tibolone", "Tibolone,anticoagulants,warfarin", "Porphyria,pregnancy,lactation,hyperplasia,malignant tumour,Migraine,Epilepsy,Asthma"),
                Medicine(86, "Ucol", "Tolterodine Tartrate", "Tolterodine Tartrate,Ketoconazole", "Lactation,urinary retention,glaucoma"),
                Medicine(87, "Detrusin", "Tolterodine Tartrate", "Tolterodine Tartrate,Ketoconazole", "Lactation,urinary retention,glaucoma"),
                Medicine(88, "Terodin", "Tolterodine Tartrate", "Tolterodine Tartrate,Ketoconazole", "Lactation,urinary retention,glaucoma"),
                Medicine(89, "Toltrex", "Tolterodine Tartrate", "Tolterodine Tartrate,Ketoconazole", "Lactation,urinary retention,glaucoma"),
                Medicine(90, "Urigen", "Tolterodine Tartrate", "Tolterodine Tartrate,Ketoconazole", "Lactation,urinary retention,glaucoma"),
                Medicine(91, "Obemet", "Metformin Hydrochloride", "Metformin Hydrochloride,Metformin,Alcohol", "Lactation,infarction,dehydration,shock"),
                Medicine(92, "Benformin", "Metformin Hydrochloride", "Metformin Hydrochloride,Metformin,Alcohol", "Lactation,infarction,dehydration,shock"),
                Medicine(93, "Bigmet", "Metformin Hydrochloride", "Metformin Hydrochloride,Metformin,Alcohol", "Lactation,infarction,dehydration,shock"),
                Medicine(94, "Comet", "Metformin Hydrochloride", "Metformin Hydrochloride,Metformin,Alcohol", "Lactation,infarction,dehydration,shock"),
                Medicine(95, "Daomin", "Metformin Hydrochloride", "Metformin Hydrochloride,Metformin,Alcohol", "Lactation,infarction,dehydration,shock"),
                Medicine(96, "Oceftil", "Cefuroxime Axetil", "Cefuroxime Axetil", "Allergy,Fasting"),
                Medicine(97, "O-Cal", "Calcium Orotate Dihydrate", "Calcium Orotate Dihydrate,tetracycline,antibiotics,bisphosphonates", "kidney stone,kidney disease,"),
                Medicine(98, "O-Morphon", "Oxymorphone Hydrochloride", "Oxymorphone Hydrochloride", "respiratory depression,asthma,hepatic impairment"),
                Medicine(99, "Narco", "Oxymorphone Hydrochloride", "Oxymorphone Hydrochloride", "respiratory depression,asthma,hepatic impairment"),
                Medicine(100, "Oxyphone", "Oxymorphone Hydrochloride", "Oxymorphone Hydrochloride", "respiratory depression,asthma,hepatic impairment"),
                Medicine(101, "Adora", "Cefadroxil-Monohydrate", " anticoagulant", "hypersensitivity"),
                Medicine(102, "Zolfin", "Aceclofenac", "Paracetamol,Aspirin", "Acidity")
                )

    }
}