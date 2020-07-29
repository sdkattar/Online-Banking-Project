import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowcustomerrequestComponent } from './showcustomerrequest.component';

describe('ShowcustomerrequestComponent', () => {
  let component: ShowcustomerrequestComponent;
  let fixture: ComponentFixture<ShowcustomerrequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowcustomerrequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowcustomerrequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
