/*
import aze.Abbasov.CatService;
import aze.Abbasov.Models.Cat;
import aze.Abbasov.Models.CatColor;
import aze.Abbasov.Models.Owner;
import aze.Abbasov.OwnerService;
import aze.Abbasov.Repository.CatRepository;
import aze.Abbasov.Repository.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class Tests {

    @Test
    public void shouldAddOwner() {
        var mockOwner = mock(OwnerRepository.class);
        var mockCat = mock(CatRepository.class);
        var ownerService = new OwnerService(mockOwner, mockCat);
        assertNotNull(ownerService.addOwner("Leha", LocalDate.now()));
    }

    @Test
    public void shouldAddCat() {
        OwnerRepository mockOwner = mock(OwnerRepository.class);
        CatRepository mockCat = mock(CatRepository.class);
        CatService catService = new CatService(mockCat, mockOwner);
        OwnerService ownerService = new OwnerService(mockOwner, mockCat);
        ownerService.addOwner("Leha", LocalDate.now());
        when(mockOwner.getOwner(anyLong())).thenReturn(new Owner());
        assertNotNull(catService.addCat("le", LocalDate.now(), "re", CatColor.RED, 1L, new ArrayList<>()));
    }


    @Test
    public void shouldAddFriend() {
        CatRepository mockCatRepository = mock(CatRepository.class);
        OwnerRepository mockOwnerRepository = mock(OwnerRepository.class);
        CatService catService = new CatService(mockCatRepository, mockOwnerRepository);
        when(mockCatRepository.getCat(Mockito.anyLong())).thenReturn(new Cat());
        catService.addFriends(4L, 5L);
        verify(mockCatRepository).addCatFriend(anyLong(), anyLong());
    }

    @Test
    public void testGetCatById() {
        CatRepository mockCatRepository = mock(CatRepository.class);
        Cat cat = new Cat();
        cat.setName("Whiskers");
        when(mockCatRepository.getCat(1L)).thenReturn(cat);

        Cat actualCat = mockCatRepository.getCat(1L);
        assertEquals(cat, actualCat);
    }

    @Test
    public void testGetOwnerById() {
        OwnerRepository mockOwnerRepository = mock(OwnerRepository.class);
        Owner owner = new Owner();
        owner.setName("John");
        when(mockOwnerRepository.getOwner(1L)).thenReturn(owner);

        Owner actualOwner = mockOwnerRepository.getOwner(1L);

        assertEquals(owner, actualOwner);
    }
}
*/
