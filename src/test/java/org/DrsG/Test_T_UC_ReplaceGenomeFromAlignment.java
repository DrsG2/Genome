package org.DrsG;

import org.DrsG.Genome.BeBl.D_BeBl_GenomeSequence;
import org.DrsG.Genome.BeBl.D_BeBl_Repository;
import org.DrsG.Genome.UC.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The T_UC_ReplaceGenomeFrom Test Class")  // give meaningful display name
public class Test_T_UC_ReplaceGenomeFromAlignment
{
    private Test_T_UC_ReplaceGenomeFromAlignment()
    {
        // If constructor required, write here
    }

    @Test
    @DisplayName("The ReplaceGenomeFromAlignment Test Case")
    // give meaningful display name
    void testGenomeSearch()
    {
        // GIVEN
        System.out.println("GIVEN: ");
        System.out.println("An Alignment, a Genome to replace and a replacement Genome");
        D_BeBl_Repository aRepository = new D_BeBl_Repository();
        T_UC_RepositoryInitiation aRepositoryInitiator = new T_UC_RepositoryInitiation();
        aRepositoryInitiator.perform(aRepository);
        //System.out.println(aRepository.getInitialOverview());

        String genomeIDToBeReplaced = "1990.U.CD.90.90CD121E12";
        String genomeIDReplacement =  "REPLACEMENT";
        T_UC_GenomeInAlignmentSearcher aGenomeSearcher = new T_UC_GenomeInAlignmentSearcher();
        D_BeBl_GenomeSequence genomeToBeReplaced = aGenomeSearcher.perform(aRepository.getOptimalAlignment(), genomeIDToBeReplaced);
        System.out.println(genomeToBeReplaced.getOverview());

        D_BeBl_GenomeSequence genomeReplacement = new D_BeBl_GenomeSequence();
        genomeReplacement.setId(genomeIDReplacement);
        genomeReplacement.setSequence(genomeToBeReplaced.getSequence());
        T_UC_ReplaceSequenceInGenomeSequence genomeSequenceReplacer = new T_UC_ReplaceSequenceInGenomeSequence();
        genomeSequenceReplacer.perform(genomeReplacement, "TTTC", "GGGG");
        System.out.println(genomeReplacement.getOverview());


        //System.out.println(aRepository.getInitialOverview());
        // WHEN
        System.out.println("Number of GenomeSequences in the Alignment = " + aRepository.getOptimalAlignment().getSampleGenomeSequences().size());
        System.out.println("WHEN: ");
        System.out.println("The replacement of a genome sequence objects from Alignment is performed");
        T_UC_ReplaceGenomeInAlignment aGenomeReplacer = new T_UC_ReplaceGenomeInAlignment();
        aGenomeReplacer.perform(aRepository.getOptimalAlignment(), genomeToBeReplaced, genomeReplacement);
       // THEN
        System.out.println("THEN: ");
        System.out.println("The to-be-replace Genome is removed and the replacment Genome is put in the same location in the Alignment as the to-to-replaced Genome");
        // Result
        System.out.println("RESULT: ");
        System.out.println("Number of GenomeSequences in the Alignment = " + aRepository.getOptimalAlignment().getSampleGenomeSequences().size());
        System.out.println(aRepository.getOptimalAlignment().getOverview());


    /* assertTrue --> Assert that condition is true
    assertFalse --> Assert that condition is false
    assertNull --> Assert that object is null
    assertNotNull --> Assert that object is not null
    assertEquals --> Assert that expected and actual are equal
    assertNotEquals -->Assert that expected and actual are not equal
    assertArrayEquals --> Assert that expected and actual arrays are equals
    assertSame --> Assert that expected and actual refer to the same object
    assertNotSame --> Assert that expected and actual do not refer to the same object
    */
    }
}
